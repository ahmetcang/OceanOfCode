# OceanOfCode  

## CODINGAME PUZZLE  
### AHMETCAN GÜRBÜZ - 20160807014  

The ship have to move. This ship can move N,E,W,S directions but can't move over island and board. The map is 15 cells width and 15 cells height. Starting position on coordinates (0,0). The ship can't move the cell which is visited before. Even if using surface can enable to get move in visited cells before but lose 1 hit point.  

The ship damage the opponent by using torpedo. Torpedo can be fire in 4 cells range and need to 3 charge to ready. Using torpedo the ship damage the oppenent to estimate oppenent position.  

I created a ship class and using get and set methods to move ship. I initialize the array 2D to represent cellValues and return boolean. If the result true, the ship move next position.    
In object Player only set the map and starting value coordinates (0,0).  

In gameloop, I represent every values and canMove function. The function is check move and enable to surface mechanism.
