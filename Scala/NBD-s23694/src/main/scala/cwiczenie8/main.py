import riak


class Main:
    def __init__(self):
        self.client = self.connectClient()
        self.bucket = self.createBucket("testing")

    def connectClient(self):
        client = riak.RiakClient(pb_port=8087, protocol='pbc')
        return client

    def createBucket(self, name):
        myBucket = self.client.bucket(name)
        return myBucket

    def uploadValue(self, name, price):
        print("Pobrano dane o cenie: " + str(price) + " produktu: " + name)
        bucketObject = self.bucket.new(name, data=price)
        bucketObject.store()

    def getValue(self, name):
        fetched = self.bucket.get(name)
        print("Cena produktu: " + name + " wynosi: " + str(fetched.data))

    def deleteObject(self, name):
        print("Produkt: " + name + " zostal usuniety")
        self.bucket.delete(name)

    def run(self):
        self.connectClient()
        self.createBucket("testing")

        self.uploadValue("MacBook", "2000")
        self.getValue("MacBook")
        self.uploadValue("Dell", "1600")
        self.getValue("Dell")
        self.deleteObject("Dell")
        self.getValue("Dell")

app = Main()
app.run()