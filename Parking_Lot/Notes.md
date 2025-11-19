# Design parking lot

## Step 1: Clarify: What and how?

### What?

#### Core objects  
 - ParkingLot System
 - Intput: vehicle
 - Output: parking spots

#### Possible questions
1. What kind of parking lot? Indoor(levels) or outdoor?
2. Vehicle
   - Can park different types of cars?
   - EV parking only?
   - Parking lot for disabilities?

#### Confirmatin from Interviewer
- Parking lot: multi-levels indoor parking lot
- vehicle: consider large, mid, and small cars
  - Large car will take more parking spaces
- We can ignore EV charger parking lot and parking lot for the disabilities

### How?

- How to park a car?
  - Need to show the no.of available parking spots
- How to charge?
  - Charge based on parking time

## Step 2: Core objects
<img width="2150" height="816" alt="Screenshot 2025-11-19 084906" src="https://github.com/user-attachments/assets/7fb838f2-9db6-4b6e-9939-33406f77f14a" />

## Step 3: Use cases

Parking lot (think like the admin)
- get available spot count (serve)
  - we have different levels, consider use level class
- park vehicle (serve)
  - check the size of vehicle
  - find an available spot for this vehicle
  - vehicle takes the spot
- clear spot (check out)
  - Parking lot find the spot to clear, consider using receipt(ticket class)
  - Update spot to be available
- calculate price (check out)
  - when clearing spot, calculate price to check out

## Step 4: Class








