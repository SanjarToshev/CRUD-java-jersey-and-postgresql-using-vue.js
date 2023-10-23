<template>
  <main>
    <Navbar />

      <!--table-->
      <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h1 class="text-center">View Users</h1>

              <a href="/add" class="btn btn-primary">Add Users</a>
              <table class="table table-striped">
                <thead>
                  <tr>
                      <th scope="col">ID</th>
                      <th scope="col">UserName</th>
                      <th scope="col">Age</th>
                      <th scope="col">Email</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="user in users" :key="user.userId">
                    <th scope="row">{{ user.userId}}</th>
                    <td>{{user.userName}}</td>
                    <td>{{user.age}}</td>
                    <td>{{user.email}}</td>
                    <td>
                        <a class="btn btn-primary" :href="'/edit/${user.userId}'">Edit</a>
                        <button class="btn btn-danger mx-2" @click="$event => deleteUsers(user.userId)">Delete</button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
      </div>


  </main>
</template>


<script>

   import Navbar from "@/components/BarNav.vue";

  export default {
    name: 'ViewUsers',
    components : {
      Navbar
    },
    data(){
      return {
        users : []
      }
    },
    methods: {
      getUsers() {
        fetch('http://localhost:8081/users/getAll')
            .then(data => {
              this.users = data
              console.log(data)
            })
      },
      deleteUsers() {
        fetch('http://localhost:8081/users/delete/${id}', {
            method: 'DELETE'
        })
            .then(data => {
              console.log(data)
              this.getUsers()
            })
      }
    }
  }

</script>