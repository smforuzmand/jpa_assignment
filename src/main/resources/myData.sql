INSERT INTO jpa_assignment.ingredient(id, ingredient_name)VALUES (1, 'Salt');
INSERT INTO jpa_assignment.ingredient(id, ingredient_name)VALUES (2, 'Sugar');
INSERT INTO jpa_assignment.ingredient(id, ingredient_name)VALUES (3, 'Carrot');
INSERT INTO jpa_assignment.ingredient(id, ingredient_name)VALUES (4, 'Cinnamon');
INSERT INTO jpa_assignment.ingredient(id, ingredient_name)VALUES (5, 'Saffron');
INSERT INTO jpa_assignment.ingredient(id, ingredient_name)VALUES (6, 'milk');
INSERT INTO jpa_assignment.ingredient(id, ingredient_name)VALUES (7, 'flour');

INSERT INTO jpa_assignment.recipe_instruction(id, instruction)VALUES (10, 'instruction for cup Cake');
INSERT INTO jpa_assignment.recipe_instruction(id, instruction)VALUES (11, 'instruction for Carrot Cake');
INSERT INTO jpa_assignment.recipe_instruction(id, instruction)VALUES (12, 'instruction for Red-velvet  ');
INSERT INTO jpa_assignment.recipe_instruction(id, instruction)VALUES (13, 'instruction for Vanilla Cake');

INSERT INTO jpa_assignment.recipe_category(id, category) VALUES (20 , 'Happy BirthDate');
INSERT INTO jpa_assignment.recipe_category(id, category) VALUES (21 , 'Graduation');
INSERT INTO jpa_assignment.recipe_category(id, category) VALUES (22 , 'Breakfast');

INSERT INTO jpa_assignment.recipe(id, recipe_name, instruction_id) VALUES (30,'carrotCake',11);
INSERT INTO jpa_assignment.recipe(id, recipe_name, instruction_id) VALUES (31,'cupCake ',10);
INSERT INTO jpa_assignment.recipe(id, recipe_name, instruction_id) VALUES (32,'Red-velvet',12);
INSERT INTO jpa_assignment.recipe(id, recipe_name, instruction_id) VALUES (33,'Vanilla',13);


INSERT INTO jpa_assignment.recipe_ingredient(recipe_ingredient_id,amount, measurement, ingredient_id, recipe_id)VALUES(40,20, 2, 7, 30);

