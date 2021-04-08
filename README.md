# **Health & Fitness application**

## **Proposal**-
This application can be used by fitness and health enthusiasts to keep a track of the number of
calories that they consume in a day so that they can reach their goal (i.e., losing weight or gaining weight).
Other functionalities include tracking the progress of their Body Weights and other body measurements.
*There are various misconceptions surrounding weight loss and weight gain in the fitness industry*. I had been 
overweight my entire life and had tried many unhealthy weight loss methods unsuccessfully. Last year, my friend
introduced me to calorie tracking. I have lost over 35 lbs since then. **Everybody's body is perfect just the way
it is and nobody should ever feel the need to under-eat because other people tell them to**. I just wanted to make
this application to help anyone interested in tracking calories and losing/gaining weight healthily.

## *User Stories*-
- As a user, I want to be able to track the number of calories I have consumed in the day.
- As a user, I want to be able to calculate the number of calories I require to maintain 
my body weight(aka. my Basal Metabolic Rate).
- As a user, I want to be able to add my current body weight, chest, shoulder and waist measurements 
to a list of my previously taken measurements.
- As a user, I want to be able to view my list of body measurements to monitor my progress.
- As a user, I want to be able to save my list of measurements to file.
- As a user, I want to be able to load my list of measurements from file.
- As a user, I want to be able to add my meals for the day with their associated preparation times.
- As a user, I want to be able to view all of my currently added meals in order of decreasing preparation times.
- As a user, I want to be able to remove a particular meal from my meals for the day.
- As a user, I want to be able to retrieve the preparation time for a particular meal.

## *Phase 4: Task 2*-
- I chose to implement the Map interface in my code.
- Class where the Map interface has been used: TodaysMeals.

## *Phase 4: Task 3*-
- Changes I would make in my project:
- I would add a new abstract class called User. This class would accept all the details about the user that
doesn't change (i.e., their height, age and gender) and store them as protected fields. These details won't 
change everytime they open the application, although it may change over time. Furthermore, this information 
is used by 2 other classes: TodaysMeasurements and UserMaintenanceCalories. Hence, these classes can extend 
the abstract class and inherit these user details.
- I would make the list of measurements a Map that has a String as the Key and a LinkedList as the Value.
The Key would be the date on which the measurement was added, and the value would be the list of measurements.
This would help the user maintain a timeline of their progression, and it would make accessing the list of 
measurements for a particular date easier. I would also add a graph to analyze a user's body-weight progression.
