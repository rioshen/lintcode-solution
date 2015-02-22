class MinStack:
    def __init__(self):
        self.stack = []
        self.minstack = []

    def push(self, number):
        self.stack.append(number)
        if not self.minstack or self.minstack[-1] >= number:
            self.minstack.append(number)

    def pop(self):
        number = self.stack.pop()
        if number == self.minstack[-1]:
            self.minstack.pop()
            return number

    def min(self):
        return self.minstack[-1]
