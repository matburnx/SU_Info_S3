#include <stdlib.h>
#include <stdio.h>

#define DIM1 5
#define DIM2 6

typedef struct _elt Elt;
struct _elt {
  int donnee;
  Elt *suivant;
}; /* 12 octets */

/* Les tableaux en 2D sont stockes a la suite dans la memoire lineairement
 * d'ou le besoin de preciser la taille de la deuxieme dimension*/
/* Tableau statique plus rapide et "simple"
 * Tableau dynamique plus flexible mais plus lent (saut de memoire) et plus difficile a gerer*/
void InitTab(char** tab, int nbL, int nbC) {
  for(int i=0; i<nbL; i++) {
    for(int j=0; j<nbC; j++) {
      tab[i][j]='0';
    }
  }
}

int main(void) {
    char** tab2D;
    tab2D=(char**)malloc(sizeof(char*)*DIM1);
    for(int i=0; i<DIM1; i++) {
      tab2D[i]=(char*)malloc(sizeof(char)*DIM2);
    }
    InitTab(tab2D,DIM1,DIM2);

    for(int k=0; k<DIM1; k++) {
      free(tab2D[k]);
    }
    free(tab2D);

    
    int taille=10;
    Elt* liste=NULL;
    Elt* nelt=NULL;
    Elt* last=NULL;
    
    for(int i=0; i<taille; i++) {
      nelt=malloc(sizeof(Elt));
      if(nelt==NULL) {
        printf("Erreur a l'allocation.\n");
        return 0;
      }
      nelt->donnee=i;
      nelt->suivant=liste;
      liste=nelt;
    }

    nelt=liste;
    while(nelt) {
      printf("%d\t", nelt->donnee);
      last=nelt;
      nelt=nelt->suivant;
      free(last);
    }
    printf("\n");

    return 0;
}
