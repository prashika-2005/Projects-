 Project Description:
Quizopedia is a console-based Java application that simulates a simple quiz game for users using fundamental Object-Oriented Programming (OOP) concepts. It allows users to answer multiple-choice questions, tracks their score, and rewards them based on their performance.

This project demonstrates real-world usage of inheritance, encapsulation, abstraction, and modularization in Java. It is interactive, user-friendly, and built with scalability and maintainability in mind.

 Core Features:
 1. User-Friendly Interface:
Welcomes user by name.

Clearly displays rules and instructions.

Offers option to start or exit the quiz.

 2. Structured Question Management:
Questions are encapsulated using a Question class.

Each question includes:

Question text

Multiple answer options

Correct answer and option index

 3. Interactive Quiz Flow:
Questions are presented one-by-one.

User enters their answer.

Immediate feedback is shown: Correct or Incorrect, with colored output (for console).

  4. Score Tracking and Feedback:
Correct answers increase the score.

Final score and percentage are displayed.

A reward is given based on performance.

 5. Reward System:
10/10:  Car

9/10:  iPhone

8/10:  Vacation Trip

Others: Encouraging message

 6. Error Handling:
Input validation for invalid answers.

Prevents crashes due to wrong input format.

// OOP Concepts Used:
Concept	Implementation
Class & Object	Used to model the quiz, question, and game logic.
Inheritance	QuizGame extends Competition to inherit score logic and question handling.
Encapsulation	Question class encapsulates all data related to a question.
Abstraction	Methods like askQuestion(), printReward() abstract complex logic.
Modularity	Code is separated into reusable classes and methods for scalability.

// Technologies Used:
Language: Java

Tools: Any Java IDE (e.g., VS Code, IntelliJ, Eclipse), Terminal/Command Prompt

No external libraries used (pure Java)

//  Learning Objectives:
Apply OOP principles in a real-world-style mini project.

Handle user input and output using Java's Scanner.

Manage question sets dynamically using lists.

Implement structured control flow and validation.

// Scope for Future Enhancements:
Add difficulty levels (Easy, Medium, Hard)

Add timer per question

Store results in a file or database

GUI-based version using Java Swing or JavaFX

Category-based questions (Tech, Sports, General Knowledge)
