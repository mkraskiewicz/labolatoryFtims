INSERT INTO category (description) VALUES ('American');
INSERT INTO category (description) VALUES ('Italian');
INSERT INTO category (description) VALUES ('Mexican');
INSERT INTO category (description) VALUES ('Fast Food');
INSERT INTO unit_of_measure (description) VALUES ('Teaspoon');
INSERT INTO unit_of_measure (description) VALUES ('Tablespoon');
INSERT INTO unit_of_measure (description) VALUES ('Cup');
INSERT INTO unit_of_measure (description) VALUES ('Pinch');
INSERT INTO unit_of_measure (description) VALUES ('Ounce');
INSERT INTO unit_of_measure (description) VALUES ('Dash');
INSERT INTO unit_of_measure (description) VALUES ('Pint');
INSERT INTO unit_of_measure (description) VALUES ('Each');
INSERT INTO recipe (cook_time, description, directions, prep_time, servings) VALUES (0, 'Guacamole',
'1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon2 Mash with a fork: Using a fork, roughly mash the avocado. (Don"t overdo it! The guacamole should be a little chunky.
                3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.
                Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.
                Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.
                4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.
"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.', 10, 4);
INSERT INTO ingredient (amount, description, recipe_id, uom_id) VALUES (2,'ripe avocados',1,8);
INSERT INTO ingredient (amount, description, recipe_id, uom_id) VALUES (0.5,'Salt',1,1);
INSERT INTO ingredient (amount, description, recipe_id, uom_id) VALUES (2,'fresh lime juice or lemon juice',1,2);
INSERT INTO ingredient (amount, description, recipe_id, uom_id) VALUES (3,'minced red onion or thinly sliced green onion',1,2);
INSERT INTO ingredient (amount, description, recipe_id, uom_id) VALUES (2,'serrano chiles, stems and seeds removed, minced',1,8);
INSERT INTO ingredient (amount, description, recipe_id, uom_id) VALUES (1,'Cilantro',1,2);
INSERT INTO ingredient (amount, description, recipe_id, uom_id) VALUES (2,'freshly grated black pepper',1,6);
INSERT INTO ingredient (amount, description, recipe_id, uom_id) VALUES (1,'ripe tomato, seeds and pulp removed, chopped',1,8);
INSERT INTO recipe_category (recipe_id, category_id) VALUES (1,1);
INSERT INTO recipe_category (recipe_id, category_id) VALUES (1,3);