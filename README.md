# Scrypt Implementation in Java
[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/LICENSE.txt)

## Overview

This repository contains a Java implementation of the Scrypt algorithm. Scrypt is a key derivation function designed to be memory-intensive and resistant to parallel processing, making it suitable for password hashing and other cryptographic applications.

## Features

- **Scrypt Algorithm Implementation:** The core of this application is the implementation of the Scrypt algorithm, providing a secure and efficient key derivation function.
  
- **Configurable Parameters:** The implementation allows you to configure various parameters of the Scrypt algorithm, such as N (CPU/memory cost), r (block size), and p (parallelization factor).

- **JavaFX User Interface:** The project includes a JavaFX-based user interface, allowing for easy interaction with the Scrypt implementation.
  
- **Usage Examples:** The repository includes examples and usage guidelines to help you integrate the Scrypt implementation into your Java projects securely.

## Getting Started

Follow these steps to get started with the Scrypt implementation:

1. **Clone the Repository:**
   
   ```bash
   git clone https://github.com/GentritIbishi/Scrypt_Implementation.git

## Configuration

Adjust the Scrypt parameters in the code according to your security requirements. The most common parameters are N, r, and p.

```java
int N = 16384; // CPU/Memory cost
int r = 8;     // Block size
int p = 1;     // Parallelization factor
```

## Preview of Application

![Preview](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/screenshots/1.png)

## Example Hash Generating in Application

### Input

```java
Plaintext: 123abcdefab
```

### Output

```java
Hash generated: $s0$e0801$eJFXz84VUfLMr/w+pvf9Aw==$iDxegp1WvrKCmJU8wcNHyCfDe6hqvK9XoTJmuy031Ac=
```

## Preview

![Preview](https://github.com/GentritIbishi/ScryptImplemenation/blob/master/screenshots/2.png)


