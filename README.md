Entities
Create these Java files with the following:
1. Class: Ingredient
   a. Contains an id.
   b. Contains a unique ingredient.
2. Enum: Measurement
   a. Specify a couple of measurements and weights that you may find suitable for a
   recipe.
   e.g. TBSP, TSP, G, HG, KG, ML, CL, DL etc.
3. Class: RecipeIngredient
   a. Contains an id of type String. Generate the id as a UUID from Hibernate.
   b. Contains a reference to Ingredient.
   c. Contains a representation of a measured amount type double.
   d. Contains a Measurement that represent the unit.
   e. Contains a reference to the associated Recipe.
4. Class: RecipeCategory
   a. Contains an id.
   b. Contains a category of type String.
   c. Contains a collection of recipes associated to this RecipeCategory.
5. Class: Recipe
   a. Contains an id.
   b. Contains a recipe name of type String.
   c. Contains a collection of recipe ingredients.
   When you remove content from this collection make sure to implement automagical
   removal of this RecipeIngredient.
   d. Contains recipe instructions of type RecipeInstruction.
   e. Contains a collection of RecipeCategory.
6. Class: RecipeInstruction
   a. Contains an id.
   b. Contains recipe instructions of type String 

