#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAILLE 6

void min_max_moy(int tab[], int taille, int *min, int *max, float *moy) {
  int i, somme=tab[0];
  *min=tab[0];
  *max=tab[0];
  for(i=1 ; i<taille ; i++) {
    if(tab[i]<*min)
      *min=tab[i];
    if(tab[i]>*max)
      *max=tab[i];
    somme+=tab[i];
  }
  *moy=(float)somme/(float)taille;
}

void min_max_moy_som(int tab[], int taille, int *min, int *max, int *som) {
  if(taille==1) {
    *min=tab[0];
    *max=tab[0];
    *som=tab[0];
  } else {
    min_max_moy_som(tab+1,taille-1,min,max,som);
    if(tab[0]<*min)
      *min=tab[0];
    if(tab[0]>*max)
      *max=tab[0];
    *som+=tab[0];
  }
}

void min_max_moy_rec(int tab[], int taille, int *min, int *max, float *moy) {
  int som;
  min_max_moy_som(tab,taille,min,max,&som);
  *moy=(float)som/(float)taille;
}

int compte_mots_chaine(char *chaine) {
  int cpt=0;

  while(*chaine) {
    if(*chaine==' '){
      chaine++;
      continue;
    }
    cpt++;
    while(*chaine && *chaine!=' ') {
      chaine++;
    }
  }

  return cpt;
}

/* int main(int argc, char **argv) */
int main() {
  int tabl[TAILLE]={1,2,3,4,0,-1};
  int min,max,i;
  float moy;

  min_max_moy(tabl,TAILLE,&min,&max,&moy);
  printf("Tableau : [%d",tabl[0]);
  for(i=1;i<TAILLE;i++) {
    printf(", %d", tabl[i]);
  }
  printf("]\n Max = %d Min = %d Moyenne = %.2f\n", max, min, moy);
  
  int *t;
  for(int taille=1;taille<100;taille++) {
    t=(int*)malloc(taille*sizeof(int));
    /* A finir */
    free(t);
  }

  char *pc=(char*)malloc((TAILLE+1)*sizeof(char));
  return 0;
}
