let le_stock = [("farine", 10);("lait",30);("sucre",10);("orange",20);("beurre",10)];;
let la_liste1 = [("sucre",5);("lait",3);("farine", 1);("beurre",1)];;
let la_liste2 = [("sucre",5);("farine", 1);("beurre",1);("orange",3)];;

let rec ajout (prod : string * int) (liste: (string*int) list) : (string*int) list=
  match liste with
  | [] -> [prod]
  | (s,n)::t -> let (sprod,vprod)=prod in if s=sprod then (s,n+vprod)::t else (s,n)::(ajout prod t);;

assert((ajout ("beurre",2) le_stock)=[("farine", 10); ("lait", 30); ("sucre", 10); ("orange", 20); ("beurre", 12)]);;
assert((ajout ("miel",3) le_stock)=[("farine", 10); ("lait", 30); ("sucre", 10); ("orange", 20); ("beurre", 10); ("miel", 3)]);;

let rec fusion (liste1 : (string * int) list) (liste2 : (string * int) list) : (string * int) list=
  match liste1 with
  | [] -> liste2
  (*| h::t -> fusion t (ajout h liste2);;*)
  | h::t -> ajout h (fusion t liste2);;

assert((fusion la_liste1 la_liste2)=[("sucre", 10); ("farine", 2); ("beurre", 2); ("orange", 3); ("lait", 3)]);;

let rec achat_produit (prod : string * int) (stock : (string * int) list):(string * int) list * int=
  let (sprod,nprod)=prod in
  match stock with
  | [] -> ([],nprod)
  | (s,n)::t -> let (new_liste,q)=achat_produit prod t in 
    if s=sprod then
    if n-nprod<=0 then (achat_produit (s,nprod-n) t) else ((s,n-nprod)::new_liste,0)
    else ((s,n)::new_liste,q);;

assert((achat_produit ("lait",1) le_stock)=([("farine", 10); ("lait", 29); ("sucre", 10); ("orange", 20); ("beurre", 10)], 0));;
assert((achat_produit ("miel",2) le_stock)=([("farine", 10); ("lait", 30); ("sucre", 10); ("orange", 20); ("beurre", 10)], 2));;
assert((achat_produit ("sucre",15) le_stock)=([("farine", 10); ("lait", 30); ("orange", 20); ("beurre", 10)], 5));;
(*
let rec achat_liste (liste : (string * int) list) (stock : (string * int) list ) : (string * int) list * (string * int) list=
  match liste,stock with
  | [],stock -> [[];stock]
  | h::t,stock -> let (new_stock,n)=(achat_produit h stock) in
*)

let rec genere_code_grey (n:int) : (int list) list=
  if n=0 then [[]] else
    List.map (fun x -> 0::x) (genere_code_grey (n-1))@
    List.map (fun x -> 1::x) (List.rev (genere_code_grey (n-1)));;

let rec parity_one (l:int list) : bool=
  match l with
  | [] -> true
  | h::t -> (h=0 && parity_one t) || (h=1 && parity_one t);;

assert((parity_one [1;1;1;1]));;

let rec change_last (l:int list) : int list=
  match l with
  | [1] -> [0]
  | [0] -> [1]
  | [] -> raise (Invalid_argument "change_last")
  | h::t -> h::(change_last t);;

assert((change_last [1;1;0])=[1;1;1]);;

(*let change_left_one (l:int list) : int list=
  let lrev=List.rev l in
  let rec aux lfinal=
  match lfinal with
  | 1::0::t -> 1::1::t
  | 1::1::t -> 1::0::t
  | _ -> raise Invalid_argument "change_left_one"
  in List.rev (aux lrev);;*)

let rec nth_gray (n:int) : int list=
  match n with
  | 0 -> [0]
  | 1 -> [1]
  | n -> (nth_gray (n/2))@[(n mod 2)];;

type scaltree =
Val of int
| Add of scaltree * scaltree
| Prod of scaltree * scaltree

let vect1 = [1;5;7;3]
let vect2 = [8;4;6;2]

let exps : scaltree = Add(Add(Prod(Val 1,Val 8),Prod(Val 5,Val 4)),Add(Prod(Val 7,Val 6),Prod(Val 3,Val 2)))

let rec construct_arb_nul (n:int) : scaltree=
  match n with
  | 0 -> Val 0
  | 1 -> Prod(construct_arb_nul (n-1), construct_arb_nul (n-1))
  | n -> Add(construct_arb_nul (n-1), construct_arb_nul (n-1));;

assert((construct_arb_nul 3)=Add (Add (Prod (Val 0, Val 0), Prod (Val 0, Val 0)), Add (Prod (Val 0, Val 0), Prod (Val 0, Val 0))));;

let rec listProd (v1 : int list) (v2: int list) : scaltree list=
  match v1,v2 with
  | [],[] -> []
  | [],v2 -> raise (Invalid_argument "listProd")
  | v1,[] -> raise (Invalid_argument "listProd")
  | x1::t1,x2::t2 -> (Prod (Val x1, Val x2))::(listProd t1 t2);;

assert((listProd vect1 vect2)=[Prod (Val 1, Val 8); Prod (Val 5, Val 4);Prod (Val 7, Val 6); Prod (Val 3, Val 2)]);;

let rec listAdd (lt: scaltree list) : scaltree list=
  match lt with
  | [] -> []
  | [_] -> raise (Invalid_argument "listAdd")
  | e1::e2::t -> (Add (e1,e2))::(listAdd t);;

assert((listAdd (listProd vect1 vect2))=[Add (Prod (Val 1, Val 8), Prod (Val 5, Val 4));Add (Prod (Val 7, Val 6), Prod (Val 3, Val 2))]);;

let construct_scaltree (v1:int list) (v2: int list) : scaltree=
  let [x1;x2]=(listAdd (listProd v1 v2)) in 
  Add (x1,x2);;

assert((construct_scaltree vect1 vect2)=Add (Add (Prod (Val 1, Val 8), Prod (Val 5, Val 4)),Add (Prod (Val 7, Val 6), Prod (Val 3, Val 2))));;

let rec eval_scaltree (t:scaltree) : int=
  match t with
  | Val i -> i
  | Prod (x1,x2) -> (eval_scaltree x1)*(eval_scaltree x2)
  | Add (v1,v2) -> (eval_scaltree v1)+(eval_scaltree v2);;

assert((eval_scaltree (construct_scaltree vect1 vect2))=76);;
