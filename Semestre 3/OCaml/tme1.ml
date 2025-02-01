let rec sum_chiffres(n : int) : int =
  if n>10 then (n mod 10) + sum_chiffres(n/10)
  else n;;

assert ((sum_chiffres 125) = 8);;

let rec nb_chiffres(n : int) : int =
  if n = 0 then 0 else 1 + nb_chiffres(n/10);;
assert ((nb_chiffres(125) = 3));;

let rec less_divider (i : int) (n : int) : int =
  if n mod i = 0  && i<n then i
  else if i=n then 0 else (less_divider (i+1) n);;

assert ( (less_divider 2 19) = 0 );;
assert ( (less_divider 7 21) = 7 );;

let rec prime (n : int) : bool =
  if n<2 then false else
  if less_divider(2)(n) = 0 then true else false;;

assert ((prime 1) = false);;

let rec next_prime(n : int) : int =
  if (prime n) = true then n else next_prime(n+1);;

assert ( (next_prime 15) = 17 );;
assert ((next_prime 0) = 2);;
assert ((next_prime 2) = 2);;

let rec nth_prime (n:int ) : int =
  if n = 0 then 2
  else let nth = nth_prime(n-1)+1 in (next_prime (nth));;

assert ((nth_prime 3) = 7);;

