#include <stdlib.h>
#include <time.h>
#include <stdio.h>
int* alloue_tableau(int n){
    int* t = malloc(sizeof(int)*n);
    return t;
}

void alloue_tableau2(int **T, int n) {
    *T=(int *)malloc(sizeof(int)*n);
}

void desalloue_tableau(int* t){
    free(t);
}

void remplir_tableau(int *t, int n, int v) {
    for(int i=0; i<n; i++) {
        t[i]=rand()%v;
    }
}
void afficher_tableau(int* t, int n){
    for(int i = 0;i<n;i++){
        printf("%d ", *(t+i));
    }
    printf("\n");
}

int somme_carre(int* t, int n) {
    int tot=0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            tot+=(t[i]-t[j])*(t[i]-t[j]);
        }
    }
    return tot;
}

int somme_carre2(int* t, int n){
    int tot = 0;
    int tot2=0;
    for(int i = 0 ; i<n; i++){
        tot += t[i];
        tot2+=t[i]*t[i];
   }
   int tot3 = 2*n*tot2 -2*tot*tot;
   return tot3;
}

int** alloue_matrice(int n){
    int** t = malloc(sizeof(int*)*n);
    for(int i = 0; i<n; i++){
        t[i] = alloue_tableau(n);
    }
    return t;
}

void desalloue_matrice(int** t, int n) {
    for(int i=0; i<n; i++) {
        desalloue_tableau(t[i]);
    }
    free(t);
}

void remplir_matrice(int** t, int n, int v){
    for(int i = 0; i<n;i++){
        remplir_tableau(*(t+i), n,v);
    }
}

void remplir_matrice_triangulaire(int** t, int n, int v, int isSup){
    for(int i = 0; i<n;i++){
        for(int j=0; j<n; j++) {
            if(isSup==1) {
                if(i<=j) {
                    t[i][j]=rand()%v;
                } else {
                    t[i][j]=0;
                }
            } else {
                if(i>=j) {
                    t[i][j]=rand()%v;
                } else {
                    t[i][j]=0;
                }
            }
        }
    }
}

void afficher_matrice(int **t, int n) {
    for(int i=0;i<n;i++) {
        afficher_tableau(*(t+i),n);
    }
}

int verif_matrice(int **t, int n) {
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            for(int k=0; k<n; k++) {
                for(int l=0; l<n; l++) {
                    if(t[i][j]==t[k][l]) {
                        return 0;
                    }
                }
            }
        }
    }
    return 1;
}


int verif_matrice2(int **t, int n, int v){
    int* vtab = alloue_tableau(v);
    int c = 0;
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            for(int k =0; k<c;k++){
                if(vtab[k]==t[i][j]){
                    return 0;
                }
            }
            vtab[c] = t[i][j];
            c = c+1;
        }
    }
    return 1;
}

int** produit_matrice(int **m1, int**m2, int n) {
    int **m3=alloue_matrice(n);
    for(int i=0; i<n;i++) {
        for(int j=0; j<n;j++) {
            m3[i][j]=0;
            for(int k=0; k<n; k++) {
                m3[i][j]+=m1[i][k]*m2[k][j];
            }
        }
    }
    return m3;
}

int** produit_matrice2(int **m1, int**m2, int n) {
    int **m3=alloue_matrice(n);
    for(int i=0; i<n;i++) {
        for(int j=0; j<n;j++) {
            m3[i][j]=0;
            int k=0;
            if(i<j){
                k = j;
            }else{
                k = i;
            }
            while (k<n){
                m3[i][j]+=m1[i][k]*m2[k][j];
                k++;
            }
        }

    }
    return m3;
}


int main() {
    srand(time(NULL));
    FILE *f=fopen("sortie_vitesse.txt","w");
    int taille=7;
    int* t = alloue_tableau(taille);
    remplir_tableau(t,taille,20);
    afficher_tableau(t,taille);
    printf("%d\n", somme_carre(t,taille));
    printf("%d\n", somme_carre2(t,taille));
    desalloue_tableau(t);

    int **m=alloue_matrice(taille);
    int **m2=alloue_matrice(taille);
    int **m3=alloue_matrice(taille);
    remplir_matrice(m, taille, 100);
    
    afficher_matrice(m, taille);
    printf("%d\n", verif_matrice(m,taille));
    printf("%d\n", verif_matrice2(m,taille,100));
    printf("------------------------\n");
    afficher_matrice(produit_matrice(m,m2,taille),taille);
    printf("-------------------------\n");
    
    printf("-------------------------\n");
    afficher_matrice(m2, taille);
    printf("-------------------------\n");
    afficher_matrice(m3, taille);
    printf("-------------------------\n");
    for(int i=1; i<21; i++) {
        m2=alloue_matrice(taille*i);
        m3=alloue_matrice(taille*i);
        remplir_matrice_triangulaire(m2,taille*i,1000,1);
        remplir_matrice_triangulaire(m3,taille*i,1000,0);
        clock_t t1=clock();
        produit_matrice(m2,m3,taille*i);
        clock_t t2=clock();
        clock_t t3=clock();
        produit_matrice2(m2,m3,taille*i);
        clock_t t4=clock();
        fprintf(f,"%d %.6f %.6f\n",i, (double) (t2-t1)/CLOCKS_PER_SEC, (double) (t4-t3)/CLOCKS_PER_SEC);
    }
    
    fclose(f);
    return 0;
}