ReactiveX - okiełznać asynchroniczność
======================================

Materiały do mojego wykładu z [Future Dev Day 2015](https://futuredevday.pl/2015/) o ReactiveX.

## Slajdy

Slajdy znajdują się w katalogu `slides/`. Powstały przy użyciu klasy [Beamer](https://www.sharelatex.com/learn/Beamer) z LaTeXa.

W pliku `main.tex` jest kod źródłowy slajdów w LaTeXu. Mając zainstalową dystrybucję LaTeXa, pakiet *Beamer* oraz narzędzie [latexmk](http://users.phys.psu.edu/~collins/software/latexmk-jcc/) można skompilować prezentację wydając polecenie

```
$ latexmk
```

W katalogu z prezentacją znajdują się już skompilowane wersje slajdów:
* `interactive.pdf` - wersja pokazywana na rzutniku w czasie prezentacji,
* `handout.pdf` - wersja bez pojedynyczych przejść, wszystkie wyliczenia są widoczne od razu

## Przykłady kodu

W katalogu `code/fdd2015` znajduje się projekt, który był użyty w czasie prezentacji jako przykład. Jest to projekt w Javie, który do utworzenia web service'u używa frameworka [Spark](http://sparkjava.com/).

Kod HTML oraz JavaScript znajduje się w katalogu `code/fdd2015/src/main/resources/static`.

Projekt wykorzystuje [Gradle](https://gradle.org/) do budowania. Do uruchomienia potrzebne jest polecenie:

```
$ ./gradlew run
```

Spowoduje to uruchomienie serwera na domyślnym porcie 4567.
