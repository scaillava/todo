# ml-mutant
Challenge MercadoLibre.

API REST Project to analize the DNA sequence of a Person (String[]) and determinate if it's mutant or human, you can also check statistics about the count of humans, count of mutants and ratio of mutants.

### Required Setup
* Java 1.8 
* Maven

### Generate the package
Open a terminal in the project path and execute:
```
%ml-mutant\mvn clean package
```
* You can check the code coverage opening ml-mutant\target\site\jacoco\index.html file
## Run
On the target folder execute:
```
%ml-mutant\target\java -jar ml-mutant-0.0.1-SNAPSHOT.jar
```

## Usage examples
### POST → localhost:5000/mutant/
#### Example 1:
```
{
    "dna": [
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCTA",
            "TCACTG"
            ]
}
Must answer: HTTP Response 200 ok and body content "true"
```
#### Example 1:
```
{
    "dna": [
            "ATGCGT",
            "ACGTAC",
            "ATCTGA",
            "AGAAGC",
            "CTCCTC",
            "TCACTG"
            ]
}
Must answer: HTTP Response 403 forbidden and body content "false"
```

### GET → localhost:5000/stats/
```
Must answer: HTTP Response 200 ok and a body content JSON like the next one:
{
    "count_mutant_dna": 1,
    "count_human_dna": 1,
    "ratio": 1.0
}
```
