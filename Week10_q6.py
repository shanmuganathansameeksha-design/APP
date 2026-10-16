% Facts
employee(ravi, 6, completed, 5).
employee(priya, 3, completed, 4).
employee(kumar, 8, not_completed, 5).
employee(meena, 7, completed, 4).

% Rule
promotion_eligible(X) :-
    employee(X, Experience, completed, Rating),
    Experience >= 5,
    Rating >= 4.

% Query
% ?- promotion_eligible(X).