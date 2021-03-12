<template>
  <div class="login_page">
    <div class="q-pa-sm q-pa-md form_div">
      <h4>Вход</h4>
      <q-form @submit.prevent="onSubmit" class="q-gutter-sm q-gutter-md">
        <q-input
          clearable
          filled
          square
          type="email"
          v-model="email"
          label="Email*"
          hint="Введите email"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Пожалуйста, заполните поле',
          ]"
        />
        <q-input
          v-model="password"
          square
          filled
          label="Пароль*"
          :type="isPwd ? 'password' : 'text'"
          hint="Введите пароль"
          lazy-rules
          :rules="[
            (val) =>
              (val && val.length > 0) ||
              'Пожалуйста, заполните поле. Пароль должен содержать больше 6 символов',
          ]"
        >
          <template v-slot:append>
            <q-icon
              :name="isPwd ? 'visibility_off' : 'visibility'"
              class="cursor-pointer"
              @click="isPwd = !isPwd"
            />
          </template>
        </q-input>
        <div>
          <q-btn
            size="15px"
            :loading="loading"
            color="primary"
            @click="simulateProgress()"
            style="width: 100%"
          >
            Войти
            <template v-slot:loading>
              <q-spinner-hourglass class="on-left" />
              Loading...
            </template>
          </q-btn>
          <q-btn
            size="15px"
            color="red-5"
            icon-right="check_circle_outline"
            label="Я не зарегистрирован(а)"
            style="width: 100%; margin-top: 5px"
            @click.native="$router.push('/auth/register')"
          />
        </div>
      </q-form>
    </div>
  </div>
</template>

<script>
export default {
name: "Login",
  data() {
    return {
      loading: false,
      email: null,
      password: null,
    };
  },
   methods: {
    onSubmit() {},
    simulateProgress() {
      // we set loading state
      this.loading = true;
      // simulate a delay
      setTimeout(() => {
        // we're done, we reset loading state
        this.loading = false;
      }, 3000);
    },
   }
}
</script>

<style scoped>
.login_page {
  width: 100%;
}
.form_div {
  border-radius: 5px;
  margin: auto;
  background-color: rgba(255, 255, 255, 0.8);
  width: 20%;
}
.form_div h4 {
  margin: 0;
  margin-bottom: 30px;
  text-align: center;
}
.about_acc {
  cursor: pointer;
  color: #128dee;
  text-decoration-line: underline;
  text-align: center;
}

@media (max-width: 1025px) {
  .form_div {
    width: 50%;
  }
}
@media (max-width: 550px) {
  .form_div {
    margin: auto;
    width: 95%;
  }
}
</style>