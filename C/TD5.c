#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "TD5.h"

int comparer_int(void *a, void *b) {
    int *p1=(int *)a;
    int *p2=(int *)b;
    if(*p1==*p2) {
        return 0;
    } else if (*p1>*p2) {
        return 1;
    } else {
        return -1;
    }
}

int comparer_str(void *a, void *b) {
    char *p1=(char *)a;
    char *p2=(char *)b;
    return strcmp(p1, p2);
}

void *dupliquer_int(void *data) {
    int *p1=(int *)malloc(sizeof(int));
    *p1=(int *)data;
    return p1;
}

void inserer_debut(Liste *liste, void *data) {
    Element *el=(Element *)malloc(sizeof(Element));
    el->data=liste->dupliquer(data);
    el->suiv=liste->tete;
    liste->tete=el;
}

void inserer_fin(Liste *liste, void *data) {
    Element *el=(Element *)malloc(sizeof(Element));
    el->data=liste->dupliquer(data);
    el->suiv=NULL;

    Element *h=liste->tete;

    if(liste->tete==NULL) {
        liste->tete=el;
    }
    while(h->suiv) {
        h=h->suiv;
    }
    h->suiv=el;
}

void inserer_place(Liste *liste, void *data) {
    Element *el=(Element *)malloc(sizeof(Element));
    el->data=liste->dupliquer(data);
    el->suiv=NULL;

    Element *h=liste->tete;

    if(liste->tete==NULL) {
        liste->tete=el;
    }
    while(h->suiv && liste->comparer(el->data,h->suiv->data)>0) {
        h=h->suiv;
    }
    Element *tmp=h->suiv;
    h->suiv=el;
    el->suiv=tmp;
}

Element *chercher(Liste *pL, void *data) {
    Element *liste= pL->tete;
    while(liste) {
        if(pL->comparer(liste->data, data)==0) {
            return liste;
        }
        liste=liste->suiv;
    }
    return NULL;
}

int main() {
    int i=5;
    Liste liste_int;
    Liste liste_str;

    liste_int.el=NULL;
    liste_int.comparer=&comparer_int;

    liste_str.el=NULL;
    liste_str.comparer=&comparer_str;

    if(chercher(&liste_int, &i)==NULL) {
        printf("Absent\n");
    }

    if(chercher(&liste_str, "toto")==NULL) {
        printf("Deuxieme absent\n");
    }

    return 0;
}