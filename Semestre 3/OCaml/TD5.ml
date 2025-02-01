let rec is_prefix (l1 : 'a list) (l2 : 'a list) : bool=
  match l1,l2 with
  | [],_ -> true
  | _,[] -> false
  | h1::t1,h2::t2 -> if h1=h2 then is_prefix t1 t2 else false;;

assert(is_prefix [] [1;2;3]);;
assert(not (is_prefix [1;2;3] [1;2]));;

let rec prefix_list (l : 'a list) : (('a list) list) =
  match l with
  [] -> [[]]
  | h::t -> [] :: (List.map (fun x -> h::x) (prefix_list t));;

let rec all_prefix_in (l1 : 'a list) (l2 : 'a list list) : bool =
  let lp1 = prefix_list l1 in
  (List.for_all (fun p -> List.mem p l2) lp1);;

let rec pref_complete (l : ('a list) list) : bool =
  (List.for_all (fun e -> (all_prefix_in e l)) l);;

let rec is_max_pref2 (l1 : 'b list) (l2 : ('a * ('b list)) list) : bool=
  match l1,l2 with
  | [],_ -> false
  | _,[] -> true
  | l1,(x,c)::t -> if is_prefix l1 c then (l1=c) && (is_max_pref2 l1 t) else (is_max_pref2 l1 t);;

assert(is_max_pref2 [0;1] [('a',[]);('b',[0]);('c',[0;1]);('d',[1]);('e',[1; 0]);('f',[1;0;0]);('g',[1;1]);('h',[1;1;0]);('i',[1;1;1])]);;
assert(not (is_max_pref2 [1;0] [('a',[]);('b',[0]);('c',[0;1]);('d',[1]);('e',[1; 0]);('f',[1;0;0]);('g',[1;1]);('h',[1;1;0]);('i',[1;1;1])]));;

let max_pref_list2 (l : ('a * ('b list)) list) : ('a * ('b list)) list=
  List.filter (fun (x,c) -> is_max_pref2 c l) l;;

assert((max_pref_list2 [('a',[]);('b',[0]);('c',[0;1]);('d',[1]);('e',[1; 0]);('f',[1;0;0]);('g',[1;1]);('h',[1;1;0]);('i',[1;1;1])])
=[('c', [0; 1]); ('f', [1; 0; 0]); ('h', [1; 1; 0]); ('i', [1; 1; 1])]);;

type 'a btree = Empty | Node of 'a * ('a btree) * ('a btree)
let tree1 = Node('a',Node('b',Empty,Node('c',Empty,Empty)),Node('d',Node('e',Node('f',Empty,Empty),Empty),Node('g',Node('h',Empty,Empty),Node('i',Empty,Empty))));;

let rec at_path (t:'a btree) (c:int list) : 'a=
  match c,t with
  | [],Node (a,g,d) -> a
  | [],Empty -> Empty
  | 0::t,Node (a,g,d) -> at_path g t
  | 1::t,Node (a,g,d) -> at_path d t
  | _,_ -> raise (Invalid_argument "at_path");;

(*assert((at_path tree1 []) = 'a');;*)

let rec paths_tree (t:'a btree) : ('a * (int list)) list=
  match t with
  | Empty -> []
  | Node (a,g,d) -> (a::[])::(List.map (fun (x,c) -> (,(0::l)) (paths_tree g))@(List.map (fun (x,c) -> (,(1::l)) (paths_tree d)));;

let rec is_tree (l : (int list) list) : bool =
  pref_complete l;;
