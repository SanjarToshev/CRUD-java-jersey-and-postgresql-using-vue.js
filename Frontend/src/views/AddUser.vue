  <template>
    <main>

      <Navbar />
      <div class="my-5">
        <div class="mx-auto w-25" style="max-width: 100%;">
          <h2 class="text-center mb-3">Add User</h2>
          <form @submit.prevent="addUser">

            <!-- UserName -->
            <div class="row">
              <div class="col-md-12 form-group mb-3">
                <label for="name" class="form-label">UserName</label>
                <input type="text" name="name"  id="name" class="form-control" placeholder="userName" required v-model="user.userName">
              </div>
            </div>

            <!-- Age -->
            <div class="row">
              <div class="col-md-12 form-group mb-3">
                <label for="age" class="form-label">Age</label>
                <input type="text" name="age"  id="age" class="form-control" placeholder="age" required v-model="user.age">
              </div>
            </div>

            <!-- Email -->
            <div class="row">
              <div class="col-md-12 form-group mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="text" name="email"  id="email" class="form-control" placeholder="email" required v-model="user.email">
              </div>
            </div>

            <div class="row">
              <div class="col-md-12 form-group">
                <input type="submit" value="Submit" class="btn btn-primary w-100">
              </div>
            </div>

          </form>
        </div>
      </div>

    </main>
  </template>

  <script>
   import Navbar from "@/components/BarNav.vue";

  export default {
    name: 'AddUser',
    components: {
      Navbar
    },
    data() {
      return {
        user: {
          userName: '',
          age: '',
          email: ''
        }
      }
    },
    methods: {
      addUser(){
        fetch('http://localhost:8081/users/add', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.user)
        })
            .then(res => res.json())
            .then(data => {
              console.log(data)
              this.$router.push("/")
            })
      }
    }
  }

  </script>

