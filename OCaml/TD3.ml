let rec add_freq (c : 'a) (l : ('a*int) list) : ('a*int) list =
  match l with
  | [] -> [(c,1)]
  | h::t -> if (fst h) = c then (fst h, (snd h)+1)::t
  else h::(add_freq c t);;

assert ((add_freq 'A' []) = [('A',1)]);;
assert ((add_freq 'A' [('D',1);('A',5);('B',3)]) = [('D',1);('A',6);('B',3)]);;

let rec freq (l : 'a list) : ('a*int) list =
  match l with
  | [] -> []
  | h::t -> add_freq h (freq t);;

assert ( (freq ['B';'D';'B';'B']) = [('B',3);('D',1)]);;

let add_fst ((x,y) : (int*int)) : (int*int) = (x+1,y);;
let add_snd ((x,y) : (int*int)) : (int*int) = (x,y+1);;

let rec nb_of(l : char list) : int*int=
  match l with
  | [] -> (0,0)
  | '<'::t -> add_fst (nb_of t)
  | '>'::t -> add_snd (nb_of t);;

let o_sup_f (l : char list) : bool =
  let (x,y)=(nb_of l) in x>=y;;

let all_o_sup_f (l : (char list) list) : bool =
  List.for_all o_sup_f l;;

let dyck (l : char list) : bool =
  let (x,y)=(nb_of l) in
    (x=y) && all_o_sup_f (prefixes l);; (*prefixes est ecrite dans TD2 2.3*)
