type 'a btree = Empty | Node of 'a * 'a btree * 'a btree;;
let t_ex = Node(5,Node(3,Node(4,Empty,Empty),Node(5,Empty,Empty)),Node(2,Node(3,Empty,Node(7,Empty,Empty)),Empty));;

let rec size(t:'a btree) : int =
  match t with
  | Empty -> 0
  | Node (a,g,d) -> 1 + size g + size d;;

assert (size Empty = 0);;
assert (size t_ex = 7);;

let rec branch_height (t : 'a btree) : int =
  match t with
  | Empty -> 0
  | Node (a,g,d) -> 1 + max (branch_height g) (branch_height d);;

let rec max_length_branch (t : 'a btree) : 'a list =
  match t with
  | Empty -> []
  | Node (a,g,d) -> let h_d = a::(max_length_branch d) in let h_g = a::(max_length_branch g) in if List.length h_d >= List.length h_g then h_d else h_g;;

assert (max_length_branch t_ex = [5;2;3;7]);;

let rec max_flow_branch (t : 'a btree) : 'a list =
  match t with
  | Empty -> []
  | Node (a,Empty,Empty) -> [a];
  | Node (a,g,d) -> let Node (b,_,_)=g in let Node (c,_,_) = d in if b>=c then a::(max_flow_branch g) else a::(max_flow_branch d);;

assert ((max_flow_branch t_ex) = [5;3;5]);;

let rec at_prof (n:int) (x:'a) (t:'a btree) : bool =
  match t with
  | Empty -> false
  | Node (x,g,d) -> if n!=0 then (at_prof (n-1) (x) (g)) || (at_prof (n-1) (x) (d)) else n=0
  | Node (a,g,d) -> (at_prof (n-1) (x) (g)) || (at_prof (n-1) (x) (d));;

assert (at_prof 0 5 t_ex);;
assert (at_prof 2 5 t_ex);;
assert (at_prof 1 5 t_ex);;

let rec at_prof_list (n:int) (t:'a btree) : 'a list=
  match t with
  | Empty -> []
  | Node (a,g,d) -> if n=0 then [a] else (at_prof_list (n-1) g)@(at_prof_list (n-1) d);;

assert((at_prof_list 2 t_ex)=[4;5;3]);;

(*let rec etiq_prof_list (x:'a) (t:'a btree) : int list=
  match t with
  | Empty -> [0]
  | Node (a,g,d) -> if x=a then 0 else (1+(etiq_prof_list x g))@(1+(etiq_prof_list x d));;

assert((etiq_prof_list 3 t_ex)=[1;2]);;
*)

let rec prof_max (t:'a btree) : int=
  match t with
  | Empty -> -1
  | Node (a,g,d) -> max (1+(prof_max g)) (1+(prof_max d));;

assert((prof_max t_ex)=3);;

let rec max_prof_etiq (x:'a) (t:'a btree) : int=
  match t with
  | Empty -> -1
  | Node (a,Empty,Empty) -> if x=a then 0 else -1
  | Node (a,g,d) -> if x=a then max 0 (1+(max ((max_prof_etiq x g)) ((max_prof_etiq x d)))) else
    max (1+(max_prof_etiq x g)) (1+(max_prof_etiq x d));;

assert((max_prof_etiq 7 t_ex)=3);;
assert((max_prof_etiq 5 t_ex)=2);;

type value = B of bool | I of int
exception TYPE_ERROR of int

let not1 (v:value) : value=
  match v with
  | B b -> B (not b)
  | I i -> raise (TYPE_ERROR i);;

let not2 (v:value) : value=
  try not1 v with
  | TYPE_ERROR i -> B (i=0);;

exception DIV_BY_0 of int

let div1 (v1:value) (v2:value) : value=
  match v1,v2 with
  | B b1,_ -> raise (Invalid_argument "v2")
  | _,B b2 -> raise (Invalid_argument "v1")
  | I n1,I 0 -> raise (DIV_BY_0 n1)
  | I n1,I n2 -> I (n1/n2);;

let div2 (v1:value) (v2:value) : value option=
  try Some (div1 v1 v2) with
  | DIV_BY_0 n -> None;;