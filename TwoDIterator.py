class TwoDIterator():
    def __init__(self, clist):
        self.ls = clist
        self.row = 0
        self.col = 0
        self.rFlag = False
        
    def hasNext(self):
        while self.row < len(self.ls) and self.col == len(self.ls[self.row]):
            self.row += 1
            self.col = 0
        return self.row < len(self.ls)
    
    def next(self):
        if not self.hasNext():
            return
        ans = self.ls[self.row][self.col]
        self.col += 1
        self.rFlag = True
        return ans
    
    def remove(self):
        if self.rFlag is False:
            return
        precol = self.col - 1
        prerow = self.row
        while precol < 0:
            prerow -= 1
            precol = len(prerow) - 1
        self.ls[prerow].pop(precol)
        self.rFlag = False
        if prerow == self.row:
            self.col -= 1
        
