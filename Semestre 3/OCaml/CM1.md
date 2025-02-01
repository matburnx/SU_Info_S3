Frederic.Perchanski@lip6.fr

Notation :
* 5% Quiz
* CC 45%
* CT 50%

Programmation fonctionnelle :
* Pas de manipulation de mémoire explicite
* Pas de notion de variable comme en impératif
Mais construction d'environnements permettant de donner des noms à des valeurs

Suite de définitions
* Les définitions permettent de construire un environnement d'évalutation

Utilisation du noyau fonctionnel d'**OCaml**.

# Expression
Premier exemple:
```ocaml
7 + 8 ;;
- : int = 15
```

`7 + 8` Expression -> Evaluation -> `15`

`+.` pour les `float`
`^` concaténation de `string`

```ocaml
let x : int = 4 * 12
```
=> Ajout de la liason `(x,2)` qui associe 2 à l'identificateur x

Environnement: Table d'association entre des variables et les valeurs

Evaluation dans un environnement d'évaluation
```ocaml
x + 3;;
- : int = 51
```

Identificateur : nom en minuscule et `_`

Types de base:
* `int`, +, -, \*, /, mod...
* `float`, +., -., \*., /., exp, log...
* `bool`, &&, ||, not
* `char`
* `string`

Conversion possible avec `float_of_int`

# Fonctions
Exemple:
Définition:
```ocaml
let succ (x : int) : int =
	x + 1
```
`succ`: nom de la fonction
`x`: paramètre
`: int`: type de retour
`x + 1`: expression / corps de la fonction

signature de la fonction : `succ (x : int) : int`

Les indications de type sont obligatoire dans l'UE

Appel de fonction (Application):
```ocaml
# (succ (3+5));;
- : int = 9
```

Plusieurs arguments:
```ocaml
(f 2 3)
```

Évaluation de `succ (3+5)`
1. Évaluation de l'argument
`succ 8`
2. a. nouvelle liaison `(x,8)`
	b. évaluation du corps dans cet environnement `x+1`
3. `9`

# Conditionnelles
`if then else`

```ocaml
let abs (x : int) : int = if x>0 then x else -x
# (abs (-2));;
- : int = 2
```

Principe d'évaluation
1. Evaluation de la condition
2. a. si la valeur est `true`, évaluation de l'expression après `then`
2. b. sinon, évaluation de `else` 

# Fonctions récursives
Exprimer des calculs répétitifs
Programmation fonctionnelle : Pas de boucles `while` ou `for`

Exemple : La factorielle
En maths : $n! = 1\times{}2\times{}3\times{}...\times{}n$
De manière récursive :
$n! = 1$ si $n=0$
$n! = n\times{}(n-1)!$ sinon

```ocaml
let rec fact(n:int) : int =
	if n=0 then 1
	else n * (fact (n-1))
```

Fonctions mutuellement récursives
```ocaml
let rec pair (n : int) : bool =
	if n = 0 then true
	else (impair (n-1))
and impair (m : int) : bool =
	if m = 0 then false
	else (pair (m-1))
```

Récursivité terminale (c.f. cours 6)

# Variables locales
```ocaml
let x : int 4 * 8 in
	x * 4
> 128
```

* Donner un nom à un calcul
* Eviter de faire plusieurs fois le même calcul

Exemple: aire d'un triangle
```ocaml
let aire_trianglen (a : float) (b : float) (c : float) : float =
	let p : float = (a+.b+.c)/.2.0 in
		(sqrt ((p-a)*(p-a)+.(p-b)*(p-b)+.(p-c)*(p-c)))
```
