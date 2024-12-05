#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "devel.h"

void *dupliquer_str(const void *src) {
  const char *str = strdup((const char *) src);
  return (void *)str;
}

void copier_str(const void *src, void *dst) {
  char * strSrc = (char *) src;
  char * strDst = (char *) dst;
  strcpy(strSrc, strDst);
}

void detruire_str(void *data) {
  free(data);
}

void afficher_str(const void *data) {
  char *str= (char *) data;
  printf("%s",str);
}

int comparer_str(const void *a, const void *b) {
  char * str_a = (char *)a;
  char * str_b = (char *)b;
  return strcmp(str_a,str_b);
}

int ecrire_str(const void *data, FILE *f) {
  char * str= (char *) data;
  return fprintf(f, "%s", str);
}

void * lire_str(FILE *f) {
  char *str=(char *)malloc(100*sizeof(char));
  int r=fscanf(f," %s",str);
  if (r<1) return NULL;
  return (void *)str;
}
