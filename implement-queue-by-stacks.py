class MyQueue(object):
    def __init__(self):
        self.inqueue = []
        self.dequeue = []

    def enqueue(self, value):
        self.inqueue.append(value)

    def dequeue(self):
        if not self.dequeue:
            while self.inqueue:
                self.dequeue.append(self.inqueue.pop())

    def top(self):
        if not self.dequeue:
            while self.inqueue:
                self.dequeue.
