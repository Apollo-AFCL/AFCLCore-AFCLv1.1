# AFCLCore

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/cdd3348ca01345e8b8bbff24707d46c1)](https://www.codacy.com/gh/Apollo-AFCL/AFCLCore-AFCLv1.1/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Apollo-AFCL/AFCLCore-AFCLv1.1&amp;utm_campaign=Badge_Grade)


A project to create and manage AFCL and CFCL workflows using Java objects.
 
## Versions
-   1.0.0 - 2020, Mai
    -   initial release

## Purpose
This aim of this project is to provide a possibility to create, parse and validate AFCL and CFCL workflows using Java objects. The following features are supported.  

### Features
-   Create a workflow using Java objects, representing AFCL or CFCL. 

-   Write internal Java objects representing the workflow to a 
    -   `.json` file
    -   `.yaml` file.

-   Parse a workflow and get an internal Java representation of the workflow. Read a 
    -   `.json` file
    -   `.yaml` file
    -   `string`

-   Validate a workflow using a predefined `.json` schema. 

## Structure
```text
.
│── src                         
│   ├── main                   
│   │   ├── java                # source code
│   │   ├── resources           
│   │   │   ├── schema.json     # .json schema to validate workflow file
│   │   │   └── schema.yaml     # .yaml schema to validate workflow file
│   │   └── ...
│   └── test                    # unit tests
└── ...
```

## Pre-Requisites
-   Gradle

## Installation
`gradle shadowJar`

## Publications
-   TBA
