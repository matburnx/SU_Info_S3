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