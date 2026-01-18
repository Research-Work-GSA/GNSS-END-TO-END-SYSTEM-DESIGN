# GNSS End-to-End System Design

An end-to-end study of **Global Navigation Satellite Systems (GNSS)** — from satellite architecture and signal modulation to receiver algorithms and a working position solver implementation in Java.

This repository focuses on **how real-world global systems work**, not on UI, frameworks, or application-level features.

---

## What This Repository Covers

This project explains GNSS holistically, across layers that are usually taught separately:

- Satellite constellation and system architecture
- Physics of time-of-flight positioning
- Spread spectrum and PRN-based signal modulation
- CDMA and correlation-based signal detection below the noise floor
- Receiver clock bias and trilateration
- Numerical position solving using least-squares
- A reference Java implementation of the core position solver

All computation is **receiver-side**, mirroring how real GNSS systems operate.

---

## Repository Structure


<img width="495" height="440" alt="image" src="https://github.com/user-attachments/assets/40baf054-d2c4-4503-ac11-102c2829b29f" />



---

## Documents

### 1. GNSS End-to-End System Design
Explains GNSS as a **large-scale distributed system**, covering:
- Space, control, and user segments
- Atomic timekeeping and orbit data
- Trilateration and receiver clock bias
- Error sources and scalability
- A fully worked numerical example

### 2. GPS Signal Modulation
Explains **how GPS signals work inside noise**, covering:
- Spread spectrum vs narrowband signals
- PRN codes and CDMA
- Correlation detection
- Early / Prompt / Late tracking
- Doppler effects and receiver hardware constraints

Together, these documents explain **how signals become coordinates**.

---

## Java Reference Implementation

The Java code provides a **minimal, readable reference implementation** of GNSS position solving:

- Uses satellite ECEF positions and pseudoranges
- Solves for receiver position and clock bias
- Uses iterative least-squares
- Matches the numerical example in the documentation

This code is intended for **educational and system-design understanding**, not production use.

---

## What This Is NOT

This repository is **not**:
- A production-grade GNSS receiver
- A hardware or RF implementation
- A real-time navigation stack
- A mobile application

The goal is **clarity of system behavior**, not completeness of implementation.

---

## Why GNSS Is a Powerful Systems Example

GNSS is a rare real-world system that:
- Scales to billions of users with no coordination
- Has no centralized request handling
- Uses physics as the transport layer
- Pushes all computation to the edge
- Maintains global availability and fault tolerance

Many modern distributed systems share these same principles.

---

## Intended Audience

- Engineers interested in large-scale systems
- System design interview preparation
- Backend / infrastructure engineers
- Engineering managers and senior ICs
- Anyone curious about how GPS actually works

---

## License

This repository is shared for educational purposes.

Diagrams are used to illustrate concepts; ownership remains with their respective sources where applicable.

---

## Final Note

GNSS works because of **careful separation of concerns**:
- Satellites broadcast time and orbit data
- Receivers perform all computation
- Networks are optional optimizations, not dependencies

This repository exists to make that design clear.
