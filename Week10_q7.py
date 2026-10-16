% Facts
slot(s1, car, available).
slot(s2, bike, occupied).
slot(s3, car, available).
slot(s4, bike, available).
slot(s5, car, occupied).

% Rule
available_slot(Slot, Vehicle) :-
    slot(Slot, Vehicle, available).

% Query: Find available car parking slots
% ?- available_slot(Slot, car).