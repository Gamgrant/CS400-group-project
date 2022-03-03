default: runTests

runTests: runDataWranglerTests runBackendDeveloperTests runAlgorithmEngineerTests runFrontEndTests

runFrontEndTests: FrontendDeveloperTests.class ShowSearcherFrontend.class IShowSearcherBackend.class IShow.class TextUITester.class
	java FrontendDeveloperTests

FrontendDeveloperTests.class: FrontendDeveloperTests.java
	javac FrontendDeveloperTests.java

ShowSearcherFrontend.class: ShowSearcherFrontend.java
	javac ShowSearcherFrontend.java

IShowSearcherBackend.class: IShowSearcherBackend.java
	javac IShowSearcherBackend.java

IShow.class: IShow.java
	javac IShow.java

TextUITester.class: TextUITester.java
	javac TextUITester.java

runDataWranglerTests: DataWranglerTests.class
	java DataWranglerTests

DataWranglerTests.class: Show.class ShowLoader.class
	javac DataWranglerTests.java

Show.class: Show.java
	javac Show.java

runBackendDeveloperTests: test.class
	java test

runAlgorithmEngineerTests: AlgorithmEngineerTests.class
	java AlgorithmEngineerTests

AlgorithmEngineerTests.class: AlgorithmEngineerTests.java HashTableSortedSets.class
	javac AlgorithmEngineerTests.java

ShowLoader: ShowLoader.java
	javac ShowLoader.java

test.class:  ShowSearcherBackend.class
	javac test.java

ShowSearcherBackend.class: ShowSearcherBackend.java
	javac ShowSearcherBackend.java

HashTableSortedSets.class: HashTableSortedSets.java HashtableMap.class
	javac HashTableSortedSets.java

HashtableMap.class: HashtableMap.java HashtableObject.class
	javac HashtableMap.java

HashtableObject.class: HashtableObject.java LinkedListNode.class
	javac HashtableObject.java

LinkedListNode.class: LinkedListNode.java MapADT.class
	javac LinkedListNode.java

MapADT.class: MapADT.java
	javac MapADT.java

clean:
	rm *.class