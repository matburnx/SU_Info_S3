let rec bin_to_int(i:int list) :int =
  match i with
    | [] -> raise (Invalid_argument "empty list")
    | [e] -> e 
    | e::r -> e + 2* bin_to_int(r);;

assert (bin_to_int [0; 1; 1] = 6);;
assert(bin_to_int [1; 1; 0; 1; 0; 1]==43);;

let rec int_to_bin(i : int) : int list =
  if i<2 then [i]
  else [i mod 2]@(int_to_bin (i/2))

;;
assert(int_to_bin 43 = [1; 1; 0; 1; 0; 1]);;
assert(int_to_bin 6 = [0; 1; 1])

let rec comp_bin(l:int list)(n:int) :int list =
  match l, n with
  | [] , n -> if n>0 then comp_bin(l)(n-1)@[0] else []
  | e::r , n ->  if n > 0 then e::comp_bin(r)(n-1) else raise (Invalid_argument "comp_bin");;

assert (comp_bin [1; 0] 4 =  [1; 0; 0; 0]);;

let rec genere_list(n : int) :int list =
  if n<2 then [] else genere_list(n-1)@[n];;

assert((genere_list 4) = [2;3;4])

let rec elimine (l : int list) (n : int) : int list =
  match l with
  | [] -> []
  | h::t -> if h mod n = 0 then elimine t n
            else h::(elimine t n);;

assert ((elimine [1; 2; 3; 4; 5; 6] 3) = [1; 2; 4; 5]);;

let rec ecreme(l : int list) : int list =
  match l with
  | [] -> []
  | h::t -> h::ecreme(elimine(t)(h));;

assert ((ecreme [2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12]) = [2; 3; 5; 7; 11]);;

let rec crible (n :int ) : int list =
  if n==1 then 
    []
  else ecreme(crible(n-1)@[n]);;  
assert (crible 20 = [2; 3; 5; 7; 11; 13; 17; 19]);;

type int_set =
| N of int_set * int_set
| E of bool;;

let ex =
N(N(E true,
E true),
N(E false,
E true));;

exception Not_perfect
exception No_fit

let rec hauteur_equilibre (t: int_set): int =
  match t with
  | E _ -> 0
  | N (E _,N _) -> raise Not_perfect
  | N (N _, E _) -> raise Not_perfect
  | N (g,d) -> 1 + max (hauteur_equilibre g) (hauteur_equilibre d);;

assert (hauteur_equilibre ex == 2);;

let rec mem (x : int) (t : int_set) : bool =
  match t with
  | E b -> if x<=1 then b else false
  | N (g,d) -> if x mod 2 = 1 then mem (x/2) d
                else mem (x/2) g;;

assert (mem 2 ex);;
assert (not (mem 1 ex));;

let rec insert_exn(t:int_set)(x:int) : int_set = 
  match t with 
  | N(E c, E b) -> if x/2 = 0 then
                    if x mod 2 =1 then
                      N(E c, E true)
                    else
                      N(E true, E b)
                    else
                      raise No_fit
  | N(g, d) -> if x mod 2 = 1 then
                      N(g,insert_exn(d)(x/2))
                       else
                      N(insert_exn(g)(x/2), d) 
  | _ -> raise No_fit;;

let rec increase_height (t : int_set) : int_set =
  match t with
  | E b -> if b then N ( E true, E false) else N (E false, E false)
  | N (g,d) -> N (increase_height g, increase_height d);;


let rec insert (x : int) (t : int_set) : int_set =
  try insert_exn t x with
  | No_fit -> (insert x (increase_height t))
  | _ -> insert_exn t x;;

let rec list_to_tree(l: int list) : int_set =
  match l with
  | [] -> N(E false, E false)
  | e::r -> let t = list_to_tree(r) in
              insert(e) (t);;

assert(list_to_tree [0;2;3] = ex);;

let rec path_list (t : int_set) : ((int list)*bool) list=
  match t with
  | E b -> [([],b)]
  | N (g,d) -> let pathg = path_list g in let pathd = path_list d in
    (List.map (fun (l,v) -> (0::l,v)) pathg)@(List.map (fun (l,v) -> (1::l,v)) pathd);;


let rec tree_to_list (t: int_set) : int list =
  let l = path_list(t) in
  List.map(fun (l,v) -> bin_to_int(l))(List.filter(fun (l,v) -> v)(l));;