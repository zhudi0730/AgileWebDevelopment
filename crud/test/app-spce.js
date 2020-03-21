const {
    app
  } = require('../src/app');
  const {
    asyncReadFile,
    asyncWriteFile
  } = require('../src/dao')
  const request = require('supertest');

  describe("app", () => {
      describe("get requese", () => {
          it("should get all tasks when request url pattern is '/api/tasks'", (done) => {
              request(app).get('/api/tasks').expect(200).expect([{"id":"1","content":"Every shalala every wo wo","createdTime":"2020-03-21T01:01:01Z"},{"id":"2","content":"Every shing a ling a ling","createTime":"2020-03-21T02:02:02Z"}]).end((err, res) => {
                if (err) throw err;
                done()
            })
          })
      })
  })