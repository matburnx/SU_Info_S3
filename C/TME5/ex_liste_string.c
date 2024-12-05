
#include <stdlib.h>
#include "liste.h"
#include "devel.h"
#include "fonctions_string.h"

int main(void) {
  PListe liste=(PListe)malloc(sizeof(Liste));
  liste->elements=NULL;
  liste->dupliquer=dupliquer_str;
  liste->copier=copier_str;
  liste->detruire=detruire_str;
  liste->afficher=afficher_str;
  liste->ecrire=ecrire_str;
  liste->lire=lire_str;
  liste->comparer=comparer_str;

  char a[10] = "ahah";
  char b[10] = "zzz";
  char c[10] = "dubitatif";

  lire_liste(liste, "chaines.txt");
  afficher_liste(liste);
  inserer_debut(liste,a);
  inserer_fin(liste,b);
  inserer_place(liste,c);
  printf("Nouvelle liste :\n");
  afficher_liste(liste);
  ecrire_liste(liste, "ecrire_chaines.txt");

  PElement elt = extraire_en_tete(liste);
  if(elt)
    printf("Tête : %s\n", (char *)(elt->data));

  PElement eltAChercher = chercher_liste_triee(liste,c);
  if(eltAChercher)
    printf("Elément à chercher : %s\n", (char *)(eltAChercher->data));
  
  PElement eltAChercher2 = chercher_liste_triee(liste,b);
  if(eltAChercher2)
    printf("Deuxième élément à chercher : %s\n", (char *)(eltAChercher2->data));
  
  detruire_liste(liste);
  return 0;
}
