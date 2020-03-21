const express = require('express')

const {
    getAllTasks,
    createTask,
    getTask,
    deleteTask
} = require('./controller')
const app = express()
app.locals.dataFilePath = "./data.json"

const port = 3000

app.use(express.json())
app.get('/', (req, res) => res.send('<h1>Hi, Welcome!</h1>'))

app.get("/api/tasks", getAllTasks)
app.post("/api/tasks", createTask)
app.get("/api/tasks/:id", getTask)
app.delete("/api/tasks/:id", deleteTask)

app.listen(port, () => console.log(`Example app listening on port ${port}!`))

exports.app = app