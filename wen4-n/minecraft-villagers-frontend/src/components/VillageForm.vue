<template>
  <b-form @submit.prevent="onClickSave">
    <b-form-group label="Название">
      <b-form-input v-model="village.name" required />
    </b-form-group>
    <div class="d-flex justify-content-end gap-2 mt-1">
      <b-button variant="secondary" @click="onClickCancel"> Отмена </b-button>
      <b-button variant="primary" type="submit" :disabled="saving">
        Сохранить
      </b-button>
    </div>
  </b-form>
</template>

<script>
export default {
  props: {
    initialVillage: {
      type: Object,
      required: true,
    },
    onCancel: {
      type: Function,
      required: true,
    },
    onSave: {
      type: Function,
      required: true,
    },
  },

  data() {
    return {
      village: { ...this.initialVillage },
      saving: false,
    };
  },

  methods: {
    onClickCancel() {
      this.onCancel();
    },

    onClickSave() {
      this.saving = true;
      this.onSave(this.village);
    },
  },
};
</script>
