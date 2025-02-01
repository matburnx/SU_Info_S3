#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Boite_Playmobil{
    int numero;
    char collection[50];
    char *description;
} Playmobil;

Playmobil *creer_boite(int num,char *collect, char *descript)
{
    Playmobil *p=(Playmobil*)malloc(sizeof(Playmobil));
    p->numero=num;
    strcpy(p->collection, collect);
    //strcpy(p->description, descript);
    p->description=strdup(descript);
    return p;
}

int main(void){
    Playmobil Tab_Playmobil[250];
    Playmobil *p;
    int nb_boites=0;
    p=creer_boite(78,"Princess", "Grand palais de princesse: magnifique palais de 3 etages relies par 2 escaliers monumentaux en colimacon. Le palais comporte plusieurs tours avec differentes pieces, en bas, cuisine, salle a manger, au premier, chambre des princesses et salle de bain, au deuxieme, salle de musique et boudoir.");
    nb_boites=nb_boites+1;
    Tab_Playmobil[nb_boites]=*p;
    p=creer_boite(123,"PlaymobilPlus","Caleche du couple royal tiree par deux chevaux arnaches et conduite par un cocher moustachu, valises et panier de pique-nique du couple royal, deux chevaux et trois personnages.");
    nb_boites=nb_boites+1;
    Tab_Playmobil[nb_boites]=*p;

    return 0;
}