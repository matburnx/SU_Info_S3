let double (x : int) : int =
  2*x;;

let somme_2double (x : int) : int =
  let p = double x
  p+(double p);;
(* ou bien (double x) + (double (double x)) mais trop d'appel de double *)

let make_even (x : int) : int =
  if (x mod 2) = 0 then x
  else double x;;

let rec sum_impairs (n : int) : int =
  if n = 0 then 0
  else 2*n-1 + (sum_impairs n-1);;

let rec sum_impairs_inf (n : int) : int =
  if (n <= 1) then 0
  else if (n mod 2)=0 then n-1 + sum_impairs_inf(n-1)
                      else n-2 + sum_impairs_inf(n-2);;

let rec u_n (n : int) : int =
  if (n = 0) then 2
  else 3*(u_n (n-1)) + 4;;
