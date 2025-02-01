# Installer GDB sur MAC

_Clara Gainon de Forsan de Gabriac_
_3 Février 2021_

**DISCLAIMER**: Ce fichier n'est pas un manuel d'installation officiel ou propre. Ce n'est qu'un ensemble de "dirty tricks" qui ont fini par faire fonctionner gdb sur mon mac.

# Pré-requis

Connectez-vous depuis une session qui a les droits de super-user (i.e., une session sur laquelle vous pouvez utiliser la commande `sudo`).

# La manip' magique
Tapez les 3 commandes suivantes à la suite dans votre terminal :
```bash
cd
touch ~/.gdbinit 
echo "set startup-with-shell off" > ~/.gdbinit
```
# Lancer GDB

Retournez dans le dossier contenant vos fichiers C.
Complilez ensuite votre programme C avec l'option `-ggdb`.

Finalement, lancez `gdb` en préfixant la commande par `sudo`:
```bash
sudo gdb mon_executable
```
# Troubleshooting
## Hanging au run

Pour une raison mystérieuse, `gdb`a parfois tendance à "hang" après qu'on a lancé la commande `run`, c'est à dire que le programme affiche un message qui ressemble à :
```
Starting Program: path/to/prog
[New Thread 0x1603 of process 16254]
```
et plus rien ne se passe. Dans ce cas, quittez la session gdb avec `ctrl+z` et relancez.

## Message d'erreur au quit
Lorsque vous quittez `gdb` (avec la commande `q`), le programme vous affiche ça :
```
(gdb) q
A debugging session is active.

	Inferior 1 [process 16271] will be killed.

Quit anyway? (y or n) 
```
Tapez `y` (pour "yes").

```
Quit anyway? (y or n) y
../../gdb/target.c:2149: internal-error: void target_mourn_inferior(ptid_t): Assertion `ptid == inferior_ptid' failed.
A problem internal to GDB has been detected,
further debugging may prove unreliable.
Quit this debugging session? (y or n) 
```
Tapez `y` (pour "yes").

```
Quit this debugging session? (y or n) y
This is a bug, please report it.  For instructions, see:
<https://www.gnu.org/software/gdb/bugs/>.
../../gdb/target.c:2149: internal-error: void target_mourn_inferior(ptid_t): Assertion `ptid == inferior_ptid' failed.
A problem internal to GDB has been detected,
further debugging may prove unreliable.
Create a core file of GDB? (y or n) 
```
Tapez `n` (pour "no") (sauf si vous voulez vraiment passer du temps à débugger, auquel cas je serai ravie que vous partagiez vos trouvailles avec le reste du cours !).