package custom

def builder = new RobotBuilder()

def robot = builder.robot("myRobot") {
    forward(dist: 20)
    left(rotation: 90)
    forward(speed: 10, duration: 5)
}
robot.go()