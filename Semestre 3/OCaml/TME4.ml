type 'a btree = Empty | Node of 'a * 'a btree * 'a btree

let bt_sujet = Node(5, Node(2,Node(1,Empty,Empty),Node(4,Node(3,Empty,Empty),Empty)),Node(6,Empty,Node(7,Empty,Node(8,Empty,Empty))))

let bt_1 = Node(2,Node(4,Empty,Empty),Empty) 
let bt_2 = Node(4,Node(6,Empty,Empty),Empty)
let bt_3 = Node(4,Node(5,Empty,Empty),Empty)
let bt_4 = Node(4,Node(3,Empty,Empty),Empty)
let bt_5 = Node(5,Node(2,Node(1,Empty,Empty),Node(4,Empty,Empty)),Node(6,Empty,Node(7,Empty,Empty)))
let bt_6 = Node(5,Node(2,Node(1,Empty,Empty),Node(4,Empty,Empty)),Node(3,Empty,Node(7,Empty,Empty)))
let bt_7 = Node(5,Node(2,Node(1,Empty,Empty),Node(4,Empty,Empty)),Node(7,Empty,Node(6,Empty,Empty)))
let bt_8 = Node(3,Node(1,Empty,Node(2,Empty,Node(2,Empty,Node(2,Empty,Empty)))),Node(5,Empty,Node(31,Node(18,Empty,Empty),Node(42,Empty,Empty))))

let b_test = Node(2,Node(2,Node(7,Empty,Empty),Empty),Node(4,Empty,Node(1,Empty,Empty)))

let rec lt_btree (t:'a btree) (x:'a) : bool=
  match t with
  | Empty -> true
  | Node (a,g,d) -> a<x && (lt_btree g x) && (lt_btree d x);;

assert((lt_btree bt_1 5) = true);;
assert((lt_btree bt_2 5) = false);;

let rec ge_btree (t:'a btree) (x:'a) : bool =
  match t with
  | Empty -> true
  | Node (a,g,d) -> a>=x && (ge_btree g x) && (ge_btree d x);;

assert((ge_btree bt_3 4) = true);;
assert((ge_btree bt_4 4) = false);;

let is_abr (bt:'a btree) : bool =
  match bt with
  | Empty -> true
  | Node (a,g,d) -> (lt_btree g a) && (ge_btree d a);;

assert(is_abr bt_5);;
assert((is_abr bt_6)=false);;

let rec mem (bt:'a btree) (x:'a) : bool=
  match bt with
  | Empty -> false
  | Node (a,g,d) -> if x=a then true else
    if x<a then mem g x else mem d x;;

assert((mem b_test 1)=false);;
assert(mem bt_5 4);;
assert((mem b_test 7)=false);;

let rec insert(bt:'a btree)(x:'a) : 'a btree =
  match bt with
  |Empty -> Node(x,Empty,Empty)
  |Node(a,m,n) -> if(x < a) then Node(a,(insert m x),n)
  else Node(a,m,(insert n x));;

assert((insert Empty 4)=Node (4, Empty, Empty));;
assert((insert bt_5 3) = Node (5, Node (2, Node (1, Empty, Empty), Node (4, Node (3, Empty, Empty), Empty)), Node (6, Empty, Node (7, Empty, Empty))));;

let rec abr_of_list (l:'a list) : 'a btree=
  match l with
  | [] -> Empty
  | h::t -> insert (abr_of_list t) h;;

let rec list_of_abr (bt:'a btree) : 'a list=
  match bt with
  | Empty -> []
  | Node (a,g,d) -> (list_of_abr g)@[a]@(list_of_abr d);;

assert((list_of_abr bt_8) = [1; 2; 2; 2; 3; 5; 18; 31; 42]);;

let abr_sort (l:'a list) : 'a list=
  list_of_abr (abr_of_list l);;

assert((abr_sort [12;3;5;42;1;18;21])=[1; 3; 5; 12; 18; 21; 42]);;

let traversal (bt : 'a btree) : 'a list =
  let rec aux (bta : 'a btree) (l : ('a btree) list) (acc : 'a list) =
  match (bta,l) with
  | (Empty,[]) -> List.rev acc
  | (Empty,(h :: t)) -> aux h t acc
  | (Node(e,g,d),lt) -> aux g (d :: lt) (e :: acc)
  in aux bt [] [];;