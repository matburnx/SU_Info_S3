type 'a htree =
Leaf of int * 'a
| Branch of int * 'a htree * 'a htree

let t_msg = Branch(17,Leaf(8,'A'),Branch(9,Branch(4,Branch(2,Leaf(1,'C'),Leaf(1,'G')),Branch(2,Leaf(1,'H'),Leaf(1,'F'))),Branch(5,Branch(2,Leaf(1,'E'),Leaf(1,'D')),Leaf(3,'B'))))
let msg = ['A';'A';'B';'A';'C';'B';'A';'G';'H';'A';'A';'F';'E';'A';'D';'B';'A']
let msg_01 = [0;0;1;1;1;0;1;0;0;0;1;1;1;0;1;0;0;1;1;0;1;0;0;0;1;0;1;1;1;1;0;0;0;1;1;0;1;1;1;1;0]

let t1 = Leaf(3,'B')
let t2 = Branch(5,Leaf(2,'Z'),Leaf(3,'B'))
let t3 = Branch(5,Leaf(2,'Z'),Leaf(3,'W'))
let t4 = Leaf(3,'K')

let l1 = [Leaf(8,'A');Leaf(3,'B');Leaf(1,'D');Leaf(1,'E');Leaf(1,'F');Leaf(1,'H');Leaf(1,'G');Leaf(1,'C')]
let l2 = [('A',8);('B',3);('D',1);('E',1);('F',1);('H',1);('G',1);('C',1)]

let rec huff_tab(t:'a htree) :('a * (int list)) list =
  match t with
  | Leaf(n,a) -> [(a, [])]
  | Branch(a,g,d) -> let t1 = huff_tab(g) in let t2 = huff_tab(d) in 
                    let res1 = List.map(fun  x -> let (c,h) = x in (c, 0::h))(t1)  
in let res2 =List.map(fun  x -> let (c,h) = x in (c, 1::h))(t2) in res1@res2;;  

assert (huff_tab(t_msg) = [('A', [0]); ('C', [1; 0; 0; 0]); ('G', [1; 0; 0; 1]); ('H', [1; 0; 1; 0]);
('F', [1; 0; 1; 1]); ('E', [1; 1; 0; 0]); ('D', [1; 1; 0; 1]);
('B', [1; 1; 1])]);;

let rec code(m:'a list)(c :('a *(int list)) list) : int list =
  match m with
  | [] -> []
  | h::t -> List.assoc(h)(c)@code(t)(c);;

assert (code (msg) (huff_tab t_msg) = [0; 0; 1; 1; 1; 0; 1; 0; 0; 0; 1; 1; 1; 0; 1; 0; 0; 1; 1; 0; 1;
0; 0; 0; 1; 0; 1; 1; 1; 1; 0; 0; 0; 1; 1; 0; 1; 1; 1; 1; 0]);;

let rec decode1 (l : int list) (t : 'a htree) : ('a * (int list))=
  match l,t with
  | _, Leaf (a,n) -> (n,l)
  | h::t, Branch (a,g,d) -> if h=0 then decode1 t g else decode1 t d
  | _,_ -> raise (Invalid_argument "decode1");;
assert ((decode1 ([0; 0; 1; 1; 1]) (t_msg)) = ('A', [0; 1; 1; 1]));;

let rec decode (l : int list) (t : 'a htree) : 'a list=
  let (a,l1)=(decode1 l t) in
  match l1 with
  | [] -> [a]
  | _ -> a::(decode l1 t);;

assert ((decode msg_01 t_msg)=['A'; 'A'; 'B'; 'A'; 'C'; 'B'; 'A'; 'G'; 'H'; 'A'; 'A'; 'F';'E'; 'A'; 'D'; 'B'; 'A']);;

let freq_ht (t:'a htree) : int = 
  match t with
  | Leaf(f,l) -> f
  | Branch(f,g,d) -> f;;

let ht_less(t1: 'a htree) (t2: 'a htree) : bool =
  freq_ht(t1)<=freq_ht(t2);;

assert(ht_less t1 t2);;

let rec min_sauf_min (lt : ('a htree) list) : ('a htree) * (('a htree) list) =
  match lt with
  | [] -> raise(Invalid_argument "liste invalide")
  | [a] -> (a,[])
  | h::t -> let (suiv,r) = min_sauf_min(t) in
          if ht_less(suiv) (h) then (suiv,h::r) else 
            (h,suiv::r);;