<template>
  <div class="page-wrapper">
    <b-card class="big-card">
      <b-form @submit.prevent="onSave">
        <b-form-group label="Название">
          <b-form-input v-model="item.name" required />
        </b-form-group>
        <b-form-group label="Количество">
          <b-form-input
            v-model.number="item.quantity"
            type="number"
            min="1"
            required
          />
        </b-form-group>

        <div class="d-flex justify-content-end gap-2">
          <b-button variant="secondary" @click="onCancel"> Cancel </b-button>
          <b-button variant="primary" type="submit"> Save </b-button>
        </div>
      </b-form>
    </b-card>
  </div>
</template>

<script>
export default {
  props: {
    startingItem: {
      type: Object,
      required: true,
    },
    createItem: {
      type: Function,
      required: true,
    },
    onReturn: {
      type: Function,
      required: true,
    },
  },

  data() {
    return {
      item: { ...this.item },
    };
  },

  methods: {
    onCancel() {
      this.onReturn();
    },

    onSave() {
      this.createItem(this.item);
      this.onReturn();
    },
  },
};
</script>
