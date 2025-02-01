# Types produits
Les valeurs peuvent être regroupées en paires pour former d'autres valeurs
```ocaml
(4, 6.7);;
(not true, 3 * 2);;
let x = (3 * 4, "ab" ^ "cd");;
```
La virgule est constructeur de paire

Si l'expression $e_1$ est de type $t_1$ et $e_2$ est de type $t_2$, alors l'expression $(e_1,e_2)$ est de type $t_1*t_2$
Et $t_1*t_2$ est un type produit

Il peut y avoir des paires dans des paires
Attention au parenthésage :
```ocaml
((1, 'a'), false) = (1, ('a', false));;
```

Fonctions prédéfinies: utilisation des projections
```ocaml
# fst : 'a * 'b -> 'a snd : 'a * 'b -> 'b
let fst (cpl : 'a * 'b) : 'a =
	match cpl with
	| (x,y) -> x
```
Fonctions polymorphes : agissent sur des paires dont les composantes sont de types quelconques
```ocaml
(fst (true || false, 4 - 6));;
- : bool = true
```

Liaison filtrante :
```ocaml
# let (x,y) = (2,true) in
if y then x else x+1;;
- : int = 2
# let z = (2, true) in 
let (x,y) = z in
if y then x else x+1;;
- : int = 2
```

Pattern matching :
```ocaml
# match (2, true) with
	| (x,y) -> if y then x else x+1;;
- : int = 2
# let z = (2, true) in 
match z with
	| (x,y) -> if y then x else x+1;;
- : int = 2
```

Variantes plus courtes, mais plus dangereuse
```ocaml
let fst ((x,y) : 'a * 'b) : 'a = x;;

let fst (cpl : 'a * 'b) : 'a =
	let (x,y) = cpl in x;;
```


```ocaml
let rec div ((a,b) : (int*int)) : (int*int) =
	if a<b then (0,a) else
		let (q,r) = div (a-b) b in
		(q+1, r);;
(* a ne pas faire !!*)
let div_partiel = div 5;;
val div_partiel : int -> (int * int);;
```

# Ordre supérieur
Un langage de programmation d'ordre supérieur est un langage dans lequel les fonctions sont des valeurs comme les autres
Fonctions qui :
* Prennent d'autres fonctions en paramètre
* Retourne des fonctions

Exemple :
Deux fonctions appliquées aux éléments d'une paire
```ocaml
let app_couple (f : 'a -> 'c) (g : 'b -> 'd) ((x,y) : 'a * 'b) : ('c * 'd) =
	(f x,g y);;

let applique_paire (f:'a -> 'b) (cpl : 'a -> 'b) : ('b * 'b) =
	(app_couple f f cpl);;
```

# Fonction anonyme
```ocaml
fun (X : t) -> e_f
```
application d'une fonction anonyme à un argument $e_a$ :
```ocaml
((fun (X : t) -> e_f) e_a)
```

Le parenthésage de l'expression fonctionnelle est nécessaire
```ocaml
((fun (x : int) -> 2*x) (2+3));;
- : int = 10
```
Lors de l'application, le corps de la fonction $e_f$ est évalué dans l'environnement courant augmenté de la liaison $(x,V_a)$ 
$V_a$ : résultat de l'évaluation de $e_a$ dans l'environnement courant
l'environnement de définition d'une fonction anonyme est l'environnement courant
Pour les fonctions **courtes et évidentes**.

# Fonctionnelles sur les listes
Exemple :
```ocaml
let paire_double (x : int) : int * int = (x,2*x);;
```
Appliquer à toute une liste :
`List.map` qui prend une fonction `f` et une liste d'élément `l : 'a list`
```ocaml
let rec map (f : 'a -> 'b) (l: 'a list) : 'b list =
	match l with
	| [] -> []
	| h::t -> (f h)::(map f t);;
```

Les folds (pliages)
Le fold_left
```ocaml
let rec fold_left (facc : 'a -> 'b -> 'a) (ini : 'a) (l : 'b list) : 'a =
	match l with
	| [] -> ini
	| h::t -> fold_left facc (facc ini h) t;;
```

facc : fonction accumulatrice du résultat
l : liste à folder
1er 'a : résultat partiel accumulé avant l'étape courante
2e 'a : résultat partiel après l'étape courante (on a pris en compte l'élément)
ini : initialisation de l'accumulateur
Exemple :
```ocaml
fold_left (fun res n -> res+1) 0 [1;2;3;4] -> 4 (* nombre d'elements *)
fold_left (fun res n -> res+n) 0 [1;2;3;4] -> 10 (* somme des elements *)
fold_left (fun res n -> res*n) 1 [1;2;3;4] -> 24 (* factorielle du dernier *)
fold_left (fun res n -> n::res) [] [1;2;3;4] -> [4;3;2;1] (* inverse liste *)
```

Lire la partie filter du diapo