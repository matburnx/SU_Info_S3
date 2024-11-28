`let f (x : tx) : tf = ef`

Évaluation de `(f e)`
* Évaluation de e
* Le corps `ef` est évalué avec la valeur de l'argument

# Listes
Liste fonctionnelles immutables
Liste OCaml sont homogènes (chaque élément est de même type)
```ocaml
'a list
```
type somme : défini à partir de constructeurs

type récursif : une liste **non vide** est définie par son premier élément et par la liste des éléments suivants

type polymorphe : paramétré par une variable de type (`'a`) désignant le type des éléments qui composent la liste

Exemples :
`[]` est la liste de type `'a list` (alpha liste) pour tout `'a`
`[1;2;3]` est la liste de type `int list` contenant les entiers $1;2;3$ dans cet ordre
$1$ est le premier élément `head` et la liste du reste `tail`

De façon primitive, une liste de type `'a list` est
* Soit la liste vide `[]`
* Soit la construction `h::t` avec
 * Un premier élément (`head`) $h$ de type `'a list`
 * Un reste (`tail`) $t$ de type `'a list`

Exemple :
`[1;2;3]` est un raccourci pour la construction `1::(2::(3::[]))`

Filtrage (pattern matching)
Expression de filtrage : `match ... with ...`
```ocaml
match [1;2;3] with
	| [] -> true
	| h::t -> false;;
(* bool = false *)

match [] with
	| [] -> true
	| h::t -> false;;
(* bool = true *)

let x = [1;2;3] in match x with
	| [] -> true
	| h::t -> false;;
(* bool = false *)

let x = [] in match x with
	| [] -> true
	| h::t -> false;;
(* bool = true *)
```

Exemples :
```ocaml
let est_niche(l:'a)->bool=
	match l with
	| [] -> true
	| h::t -> false;;

let rec longueur(l:'a)->bool=
	match l with
	| [] -> 0
	| h::t -> 1 + (longueur t);;
```

"Ajout" d'un élément à la fin d'une liste
```ocaml
let rec add_end (e : 'a) (l : 'a list) : 'a list =
	match l with
	| [] -> [e]
	| h::t -> h::(add_end e t);;
```

**Important** : le pattern-matching doit être exhaustif
Fonction partielle : 
* arrêter le programme par une exception
* boucle infinie dans certaines conditions
Exemple : récepteur d'une tête de liste
```ocaml
let head (l : 'a list) : 'a =
  match l with
  | [] -> failwith "liste vide" 
  | h::t -> h
```
Fonction `head` totale ?
* Solution 1 : Utiliser le type `option`
* Solution 2 : Passage d'une valeur par défaut
```ocaml
let head (l : 'a list) (d: 'a) : 'a =
  match l with
  | [] -> d
  | h::t -> h;;
```
La fonction `head` est déconseillée
Filtrage linéaire
```ocaml
let foo (l : 'a list) : bool =
  match l with
  | x::(y::_) -> (x=y)
  | _ -> false;;
```
Ajout d'un élément en tête de liste :
```ocaml
let add_head (e : 'a) (l : 'a list) : 'a list=
  e::l;;
```
Exercice : Concaténation de 2 listes
```ocaml
let rec app (l1 : 'a list) (l2 : 'a list) : 'a list =
  match l1 with
  | [] -> l2
  | h1::t1 -> h1::(app t1 l2);;
```
Exercice : Renverser une liste en récursive
