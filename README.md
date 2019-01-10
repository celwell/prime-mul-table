# prime-mul-table

Command line program that prints out a multiplication table of the first 'n' prime numbers, default to n = 10.

## Build

To build the standalone JAR file, use:

    $ lein uberjar

## Usage

To run from terminal, use the JAR file:

    $ java -jar prime-mul-table-1.0.0-standalone.jar [args]

## Options

These options are accepted as arguments:

```
-n, --n <number>   The number of prime numbers in multiplication table. (default: 10)
-t, --time         Show elapsed time (including finding primes and construction/printing of table)
```

## Examples

To create a multiplication table of the first 6 prime numbers:

    $ java -jar prime-mul-table-1.0.0-standalone.jar -n 6
    
Output:

```
     |   2 |   3 |   5 |   7 |  11 |  13 |
-----+-----+-----+-----+-----+-----+-----+
   2 |   4 |   6 |  10 |  14 |  22 |  26 |
-----+-----+-----+-----+-----+-----+-----+
   3 |   6 |   9 |  15 |  21 |  33 |  39 |
-----+-----+-----+-----+-----+-----+-----+
   5 |  10 |  15 |  25 |  35 |  55 |  65 |
-----+-----+-----+-----+-----+-----+-----+
   7 |  14 |  21 |  35 |  49 |  77 |  91 |
-----+-----+-----+-----+-----+-----+-----+
  11 |  22 |  33 |  55 |  77 | 121 | 143 |
-----+-----+-----+-----+-----+-----+-----+
  13 |  26 |  39 |  65 |  91 | 143 | 169 |
-----+-----+-----+-----+-----+-----+-----+
```

## Run Tests

The test suite can be run with:

    $ lein test

## Documentation

* [API Docs](http://celwell.github.io/prime-mul-table)

## License

Copyright © 2019 Christopher Elwell

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
