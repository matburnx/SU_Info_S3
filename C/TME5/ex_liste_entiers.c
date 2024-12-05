
#include <stdlib.h>
#include "liste.h"
#include "devel.h"
#include "fonctions_entiers.h"

/*
void fonction(void *data, void *oa) {
  int n= *(int *)data;
  
}
*/

int main(void) {

  PListe liste=malloc(sizeof(Liste));
  PListe liste2=malloc(sizeof(Liste));
  liste->elements=NULL;
  liste->dupliquer=dupliquer_int;
  liste->copier=copier_int;
  liste->detruire=detruire_int;
  liste->afficher=afficher_int;
  liste->ecrire=ecrire_int;
  liste->lire=lire_int;
  liste->comparer=comparer_int;

  liste2->elements=NULL;
  liste2->dupliquer=dupliquer_int;
  liste2->copier=copier_int;
  liste2->detruire=detruire_int;
  liste2->afficher=afficher_int;
  liste2->ecrire=ecrire_int;
  liste2->lire=lire_int;
  liste2->comparer=comparer_int;

  lire_liste(liste2, "entiers.txt");
  //afficher_liste(liste2);
  int a=0;
  int c=12;
  inserer_debut(liste,&a);
  for(int i=0; i<20; i++) {
    inserer_fin(liste,&i);
  }
  
  inserer_place(liste,&c);
  afficher_liste(liste);
  ecrire_liste(liste, "ecrire.txt");
  
  int f=8;
  PElement elt=extraire_en_tete(liste);
  if(elt)
    printf("Premier élément : %d\n", *(int *)(elt->data));

  PElement eltAChercher=chercher_liste_triee(liste,&c);
  if(eltAChercher)
    printf("Elément à chercher : %d\n", *(int *)(eltAChercher->data));
  
  PElement eltAChercher2=chercher_liste(liste,&f);
  if(eltAChercher2)
    printf("Deuxième élément à chercher : %d\n", *(int *)(eltAChercher2->data));

  detruire_liste(liste);
  detruire_liste(liste2);
  return 0;
}
