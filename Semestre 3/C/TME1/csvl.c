#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int compte_mots_chaine(char *chaine) {
  int nb_mots=0;
  while(*chaine) {
    if(*chaine==' ') {
      chaine++;
      continue;
    }
    nb_mots++;
    while(*chaine && *chaine!=' ') {
      chaine++;
    }
  }
  return nb_mots;
}

char **decompose_chaine(char *chaine)
{

  /* Fonction vue en TD, exercice 2, question 7 */

  char *pc= chaine;
  int nb_mots=0;
  char **ptab;
  char *psrc_mot;
  int ind_mot=0;

  //comptages des mots
  nb_mots=compte_mots_chaine(chaine);
	
  if (nb_mots == 0)
    return NULL;
  // allocation du tableau

  ptab = malloc((nb_mots + 1) * sizeof(char *));
  ptab[nb_mots] = NULL;
	
  // copie des mots
	
  pc=chaine;
  while (*pc)
    {
      if(*pc == ' ')
        {
          pc++;
          continue;
        }

      psrc_mot = pc;

      while((*pc != ' ') && (*pc)) pc++;

      //allocation du mot
      ptab[ind_mot] = malloc((pc - psrc_mot + 1)* sizeof(char));
      //copie du mot
      memcpy(ptab[ind_mot], psrc_mot, pc - psrc_mot);
      //insertion du marqueur de fin de chaine
      *(ptab[ind_mot] + (pc - psrc_mot)) = '\0';

      ind_mot++;
    }
	

  return ptab;
}

char *compose_chaine(char **ptab_mots)
{
  int longueur = 0;
  for(int i=0; ptab_mots[i]; i++) {
    longueur+=strlen(ptab_mots[i]);
  }
  char *nouvelleChaine=(char *)malloc(longueur*sizeof(char *));

  int iChaine=0;
  for(int j=0; ptab_mots[j]; j++) {
    for(int iMots=0;ptab_mots[j][iMots];iMots++) {
      if(iChaine>1 && nouvelleChaine[iChaine-1]==' ' && ptab_mots[j][iMots]==' '){
        continue;
      } else if(ptab_mots[j][iMots]) {
        nouvelleChaine[iChaine]=ptab_mots[j][iMots];
        iChaine++;
      }
    }
  }

  return nouvelleChaine;
}

void detruit_tab_mots(char **ptab_mots)
{

  /* Fonction vue en TD, exercice 2, question 5 */

  int i=0;

  if (ptab_mots)
    while(ptab_mots[i])
      free(ptab_mots[i++]);

  free(ptab_mots);
}

int compte_mots(char **ptab_mots)
{
  int i=0;
  while(ptab_mots[i]) {
    i++;
  }
  return i;
}

void affiche_tab_mots(char **ptab_mots)
{
  for(int i=0; ptab_mots[i]; i++) {
    int j = 0;
    while(ptab_mots[i][j]) {
      printf("%c",ptab_mots[i][j]);
      j++;
    }
    printf("\n");
  }
}

char **reduit_tab_mots(char **ptab_mots)
{
  char **nouvelleChaine=(char **)malloc(compte_mots(ptab_mots)*sizeof(char **));
  nouvelleChaine=ptab_mots;

  for(int i=0; nouvelleChaine[i]; i++) {
    for(int j = 0; j<i ; j++) {
      if(strcmp(nouvelleChaine[i],nouvelleChaine[j])) {
        char *motEnTrop=nouvelleChaine[i];
        nouvelleChaine[i]=nouvelleChaine[j];
        free(motEnTrop);
      }
    }
  }
  return nouvelleChaine;
}

int main() {
  char mot1[10]="bonjour ";
  char mot2[10]=" tout ";
  char mot3[10]="le  monde";

  char *tabMots2[4]={mot1,mot2,mot3};
  char**tabMots=decompose_chaine("mot1 et mot2 et mot3");
  printf("%d\n", compte_mots(tabMots2));
  affiche_tab_mots(tabMots2);
  char *motsComp = compose_chaine(tabMots2);
  printf("%s\n", motsComp);

  char **tabMotsNouveau=reduit_tab_mots(tabMots);
  affiche_tab_mots(tabMotsNouveau);

  free(tabMots);
  free(motsComp);

  return 1;
}
