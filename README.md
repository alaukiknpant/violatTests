# violatTests


- Attempts to test simple used defined Abstract Data Types using Violat

Commands Used

- javac <NameOfJavaFile.java>
- jar cvf asd.jar com
- violat-validator <NameOfJavaFile.json> --jar asd.jar

Result
```java
iMac:Counter user$ violat-validator CounterCorrect2.json --jar asd.jar 
violat version 1.0.16
---
Unhandled promise rejection:
Error: AssertionError [ERR_ASSERTION]: Expected pending result.
    at JCStressTester.getResults (/usr/local/lib/node_modules/violat/src/java/jcstress/executor.ts:206:15)
    at processTicksAndRejections (internal/process/task_queues.js:93:5)
    at StaticOutcomesTester.getViolations (/usr/local/lib/node_modules/violat/src/alg/testing.ts:51:20)
    at RandomTestValidator.getViolations (/usr/local/lib/node_modules/violat/src/alg/validation.ts:63:22)
    at main (/usr/local/lib/node_modules/violat/src/cli/validator.ts:112:20)
```

```java
iMac:QueueSynchronized user$ violat-validator QueueSynchronizedWrong.json --jar asd.jar 
violat version 1.0.16
---
Unhandled promise rejection:
Error: SyntaxError: Unexpected token Q in JSON at position 1
    at JCStressTester.getResults (/usr/local/lib/node_modules/violat/src/java/jcstress/executor.ts:206:15)
    at processTicksAndRejections (internal/process/task_queues.js:93:5)
    at StaticOutcomesTester.getViolations (/usr/local/lib/node_modules/violat/src/alg/testing.ts:51:20)
    at RandomTestValidator.getViolations (/usr/local/lib/node_modules/violat/src/alg/validation.ts:63:22)
    at main (/usr/local/lib/node_modules/violat/src/cli/validator.ts:112:20)

```
    
    
```