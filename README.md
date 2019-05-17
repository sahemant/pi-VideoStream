# Raspberry PI Video Stream
Using this we can play any video from our system/computer to Raspberry PI connected in the same network. video format must be supported by raspberry pi.
## Installation
1. Compile both `Server_PI` and `Client_PC` within Raspberry or Computer in which Java JDK is installed.<br />
```bash
javac ServerGUI.java
```
```bash
javac ClientGUI.java
```
2. Copy all the class files in `Server_PI` to `Raspberry PI` and all class files in `Client_PC` to `Computer` from which video has to be played<br/>

## Usage
1. First Start the Server in Raspberry PI by running following command in the directory where class files are located.<br/>
```bash 
java ClientGUI
```
2. Now Start the Client in the Computer by running following command in the directory where Client class files are located.<br/>
```bash
java ServerGUI
```
