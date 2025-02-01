#include <stdio.h>

typedef struct _Element {
    struct _Element *suiv;
    void *data;
} Element;

typedef struct _liste {
    Element *tete;
    int (*comparer)(void *a, void *b);
    void *(*dupliquer)(void *data);
} Liste;

void detruire_liste(Element *liste);

void afficher(void *d);
void ecrire(void *d, FILE *f);
void lire(FILE *f);

void inserer_debut(Liste *liste, void *data);
void inserer_fin(Liste *liste, void *data);
void inserer_place(Liste *liste, void *data);
Element *chercher(Liste *pL, void *data);

void liberer(void *data);
